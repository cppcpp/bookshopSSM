var uAddress='',uReceiver='',oPhone='',orderDetails=[];
let categoryArray = [
         	        {name:'马列主义、毛泽东思想(A)',value:'a'},
         	        {name:'哲学(B)',value:'b'},
         	        {name:'社会科学(C)',value:'c'},
         	        {name:'政治、法律(D)',value:'d'},
         	        {name:'军事(E)',value:'e'},
         	        {name:'经济(F)',value:'f'},
         	        {name:'文化、科学、教育、体育(G)',value:'g'},
         	        {name:'语言、文字(H)',value:'h'},
         	        {name:'文学(I)',value:'i'},
         	        {name:'艺术(J)',value:'j'},
         	        {name:'历史、地理(K)',value:'k'},
         	        {name:'自然科学总论(N)',value:'n'},
         	        {name:'数理科学和化学(O)',value:'o'},
         	        {name:'天文学、地球科学(P)',value:'p'},
         	        {name:'生物科学(Q)',value:'q'},
         	        {name:'医药、卫生(R)',value:'r'},
         	        {name:'农业科学(S)',value:'s'},
         	        {name:'工业科学(T)',value:'t'},
         	        {name:'交通运输(U)',value:'u'},
         	        {name:'航空、航天(V)',value:'v'},
         	        {name:'环境科学(X)',value:'x'},
         	        {name:'综合性图书(Z)',value:'z'}
         	
         	]
$(function(){
	 $("#searchBtn").click(function(){
		  if($("#searchBook").val()!=""){
			  window.location="searchBook.html?data="+$("#searchBook").val()
		  }
	  })
	function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i")
		var r = window.location.search.substr(1).match(reg)
		 if (r != null) return unescape(r[2]); 
        return null; 
	}
    function getActiveNav(category){
    	
		for(var i = 0; i<categoryArray.length;i++){
			if(category.indexOf( categoryArray[i].value)!=-1){
				$(".list li").eq(i).addClass("categroy-nav-active")
			}
		}
	}
   
		
	var bookId = getQueryString('bId')
	 getActiveNav(bookId)
	var bName,bNums,bPrice,bDiscountprice,bSumprice,bSumdiscountprice,bImg;
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
					bImg = ndata['bPic']
					html += "<p class=\"details\">"+ndata["bDescription"]+"</br>";
					html += "购买信息：已有"+ndata['bSaleNum']+"人购买</p>";
					html += "<div class=\"price\"><strong>价格:</strong> <span class=\"red\">"+(ndata['bDiscount']/100 *ndata['bPrice']).toFixed(2);
					html += "<span class=\"delete_decoration\">原价："+ndata['bPrice']+"</span></div>";
					html1 += "<a href=\"#\" ><img style=\"width:150px;height: 150px;\" src=\"/book_images/"+ndata['bPic']+"\" /></a>";
					html1 += "<br/><br/>"
					/*html1 += "<br /><br /><img src=\"img/zoom.gif\" /></a>"*/
					//图书详情
					tab1 += " <ul class=\"demo-list\">"
					tab1 += "<li>图书名称："+ndata['bName']+"</li>"
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
				limit:6
			},
			success:function (data){
				var tab2 = ''
				$.each(data.books,function(index,ndata){
					if(bookId !=ndata.bId){
						tab2 += "<div class=\"col-md-4\">"
							tab2 += "<div class=\"new_prod_box\" style=\"height:150px;\">"	
							tab2 += " <a href=\"detail.html?bId="+ndata['bId']+"\" style=\"white-space:nowrap;text-overflow:ellipsis;overflow: hidden;width: 100px;\">"+ndata['bName']+"</a>"
							tab2 += " <a href=\"detail.html?bId="+ndata['bId']+"\"><img src=\"/book_images/"+ndata['bPic']+"\" class=\"thumb\" border=\"0\" width=\"90px\" height=\"90px\"/></a>"
							tab2 +="</div></div>";
					}
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
		
		  let obj = {};
		  let selectedGoods = [];
		  	bNums = $("#num_text").val();
			bSumprice = bNums * bPrice;
			bSumdiscountprice = bNums * bDiscountprice;
		    obj = {"bId":bookId,
				  "imgSrc":"/book_images/"+bImg,
				  "bName":bName,
				  "bPrice":bPrice+"",
				  "bDiscountprice":bDiscountprice+"",
				  "bNum":bNums,
				  "bSumdiscountprice":bSumdiscountprice.toFixed(2)+"",
				  "bSumprice":bSumprice+""};
		    selectedGoods.push(obj)
		  console.log(obj)
		  sessionStorage.setItem("selectedGoods",JSON.stringify(selectedGoods))
		  setTimeout("javascript:location.href='confirmOrder.html'", 1000); 
		  
	});
	
})