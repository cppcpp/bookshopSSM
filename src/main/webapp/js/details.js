var uAddress='',uReceiver='',oPhone='',orderDetails=[];
$(function(){
	function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i")
		var r = window.location.search.substr(1).match(reg)
		 if (r != null) return unescape(r[2]); 
        return null; 
	}
	var bookId = getQueryString('bId')
	var bName,bNums,bPrice,bDiscountprice,bSumprice,bSumdiscountprice
	if(bookId) {
		$.ajax({
			url:'books/booksQry',
			method:'get',
			data:{
				"bId":bookId
			},
			success:function(data) {
				var html = '';
				var html1 = ''
				var tab1 = ''
				$.each(data.books,function(index,ndata){
					$("#book_name").html(ndata['bName'])
					bName = ndata['bName']
					bPrice = ndata['bPrice']
					bDiscountprice = (ndata['bDiscount']/100 *ndata['bPrice']).toFixed(2)
					html += "<p class=\"details\">"+ndata["bDescription"]+"</br>";
					html += "购买信息：已有"+ndata['bSaleNum']+"人购买</p>";
					html += "<div class=\"price\"><strong>价格:</strong> <span class=\"red\">"+(ndata['bDiscount']/100 *ndata['bPrice']).toFixed(2);
					html += "<span class=\"delete_decoration\">原价："+ndata['bPrice']+"</span></div>";
					html1 += "<a href=\"#\" ><img style=\"width:150px;height: 150px;\" src=\"img/book_images/"+ndata['bId']+".jpg\" /></a>";
					html1 += "<br /><br /><img src=\"img/zoom.gif\" /></a>"
					//图书详情
					tab1 += "<p class=\"more_details\">图书名称："+ndata['bName']+"</p>"
					tab1 += " <ul class=\"demo-list\">"
					tab1 += "<li>图书作者："+ndata['bAuthor']+"</li>"
					tab1 += "<li>图书出版时间："+ndata["bPressTime"]+"</li>"
					tab1 += "<li>图书出版社："+ndata["bPress"]+"</li>"
					tab1 += "<li>图书原价："+ndata["bPrice"]+"</li>"
					var dis = ndata["bDiscount"] == 100 ?'无折扣':ndata["bDiscount"]+'折'
					tab1 += "<li>图书打折情况："+dis+"</li>"
					tab1 += "<li>图书服务情况："+ndata['bService']+"</li>"
               
					$("#book_detail").html(html);
					$(".prod_img").html(html1);
					$("#tab1").html(tab1)
					
				})
			},
			error: function() {
				
			}
		})
		
		$.ajax({
			url:'books/initBooks',
			type:'get',
			data:{
				category: bookId.substr(0,1),
				limit:4
			},
			success:function (data){
				var tab2 = ''
				$.each(data.books,function(index,ndata){
					tab2 += "<div class=\"col-md-4\">"
					tab2 += "<div class=\"new_prod_box\">"	
					tab2 += " <a href=\"detail.html?bId="+ndata['bId']+"\" style=\"white-space:nowrap;text-overflow:ellipsis;overflow: hidden;width: 100px;\">"+ndata['bName']+"</a>"
					tab2 += " <a href=\"detail.html?bId="+ndata['bId']+"\"><img src=\"img/book_images/"+ndata['bPic']+"\" class=\"thumb\" border=\"0\" width=\"90px\" height=\"90px\"/></a>"
					tab2 +="</div></div>";
				});
				$("#tab2").html(tab2)
			},
			error:function(){
				
			}
			
		})
		$("#tab2").css('height','300px')
	}
	
	//图书详细信息  增加和减少图书
    var inp = $("#num_text");
    var b_id = $("#b_id_text");
    
	$(".desc").click(function() {
		value = Number(inp.val());
		value -= 1;
		if(value<1){
			value = 1;
		}
		inp.val(value);
	})
	
	$(".plus").click(function() {
		value = Number(inp.val());
		value += 1;
		if(value<1){
			value = 1;
		}
		inp.val(value);
	})
	
	//获取图书信息  准备存入数据库cart数据表中
	$("#add_cart").click(function(){ 
		bNums = $("#num_text").val()
		bSumprice = bNums * bPrice
		bSumdiscountprice = bNums * bDiscountprice
		var obj = JSON.stringify({
				"bId":bookId,
				"bName":bName,
				"bNums":bNums,
				"bPrice":bPrice,
				"bDiscountprice":bDiscountprice,
				"bSumprice":bSumprice,
				"bSumdiscountprice":bSumdiscountprice
			})
		$.ajax({
			url:'cart/addCart',
			type:'post',
			data:obj,
			contentType: "application/json; charset=utf-8",
			success:function(data){
				if(data=="userNotLogin"){
					window.location="login.html"
				}else {
					window.location = "detail.html?bId="+bookId
				}
			},
			error:function(){
			}
		})
	})
	
		//得默认地址
  	$.ajax({
			url:'userAdress/getUserDefaultAddress',
			type:'get',
			success:function(data){
				if(data.defaultUserAddress ){
					uReceiver = data.defaultUserAddress.oReceiver;
					oPhone = data.defaultUserAddress.oPhone;
					uAddress = data.defaultUserAddress.uAddress;
				}
			
			}
  		})
	
	$("#now_order").click(function(){
		bNums = $("#num_text").val();
		bSumprice = bNums * bPrice;
		bSumdiscountprice = bNums * bDiscountprice;
		let obj = {
				"bId":bookId,
				'bName':bName,
				"bNums":bNums,
				"bPrice":bPrice,
				"bDiscountprice":bDiscountprice,
				"bSumprice":bSumprice,
				"bSumdiscountprice":bSumdiscountprice
		};
		orderDetails.push(obj);
		let objects = {'orderDetails':orderDetails,
				"oNum":bNums,
				"oPrice":bSumdiscountprice,
				"uAddress":uAddress,
				"uReceiver":uReceiver,
				"oPhone":oPhone,
				"oCheaper":(bSumprice-bSumdiscountprice).toFixed(2)}
		$.ajax({
			url:'orders/addOrders',
			type:'post',
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify(objects),
			success:function(data){
			
				if(data=="userNotLogin"){
					window.location="login.html"
				}else {
					/* window.location="mineOrders.html" */
				}
			}
		})
	});
	
})