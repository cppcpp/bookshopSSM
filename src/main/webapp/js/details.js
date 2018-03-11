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
				console.log(data)
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
				console.log(data)
			},
			error:function(){
				
			}
		})
	})
	
})