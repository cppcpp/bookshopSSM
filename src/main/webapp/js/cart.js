var multiDeleteArr = []
var selectedGoods = []
var flag = false;
var currentName;
var totalPage,currpage,limit
$(function(){
  getCartList()
  $("body").on("click",".selectSub",function(){
	  currentName = this.parentNode.parentNode.getAttribute('id')
	  if(this.checked){
		  if(multiDeleteArr.length){
			  for(var i=0;i<multiDeleteArr.length;i++){
				  if(currentName ==multiDeleteArr[i]){
					  flag=true;
					  break;
				  }
			  }
		  }
		  if(!flag){
			  multiDeleteArr.push(currentName) 
		  }
	  }else {
		  if(multiDeleteArr.indexOf(currentName) != -1){
			  multiDeleteArr.splice(multiDeleteArr.indexOf(currentName),1)
		  }
	  }
  })
	
  //购物车中的增加数量的功能
  $("body").on('click','.plus',function(){
    //获取总价列
    var sum_money = this.parentNode.nextSibling;
    while(sum_money.nodeName=="#text"){
      sum_money = sum_money.nextSibling;
    }
    //获取打折单价列
    var price = this.parentNode.previousSibling.previousSibling;
    while(price.nodeName=="#text"){
      price = price.nextSibling;
    }
    every_price = Number(price.innerHTML);
    //改变数量
    var num = this.previousSibling;
    while(num.nodeName=="#text"){
      num = num.previousSibling;
    }
    var num_text = num.value ;
    num_text = Number(num_text)+1;
    num.value = num_text;
    sum_money.innerHTML = (num_text*every_price).toFixed(2);
    //获取复选框
    var check = this.parentNode.parentNode.childNodes;
    subCheck = check[1].childNodes;
    var c = document.getElementsByClassName("sum_money");
    var d = 0;
    for(var i=0;i<c.length;i++){
      d += Number(c[i].innerHTML);
    }
    if(subCheck[0].checked){
      $(".ac_money").html(d.toFixed(2));
    }
    getSumPrice()
  })

  //购物车中减少数量的功能
  $("body").on("click",".desc",function(){
    //获取总价列
    var sum_money = this.parentNode.nextSibling;
    while(sum_money.nodeName=="#text"){
      sum_money = sum_money.nextSibling;
    }
    //获取单价列
    var price = this.parentNode.previousSibling.previousSibling;
    while(price.nodeName=="#text"){
      price = price.nextSibling;
    }
    every_price = Number(price.innerHTML);
    //获取复选框
    var check = this.parentNode.parentNode.childNodes;
    subCheck = check[1].childNodes;
    var num = this.nextSibling;
    while(num.nodeName=="#text"){
      num = num.nextSibling;
    }
    var num_text = num.value;
    num_text = Number(num_text)-1;
    if(num_text<=1){
      num_text=1;
    }
    num.value = num_text;
    sum_money.innerHTML =  (num_text*every_price).toFixed(2);

    var c = document.getElementsByClassName("sum_money");
    var d = 0;
    for(var i=0;i<c.length;i++){
      d += Number(c[i].innerHTML);
    }
    if(subCheck[0].checked){
      $(".ac_money").html(d.toFixed(2));
    }
    getSumPrice()
  });

 
  
    //购物车中的删除
    $("body").on('click','.delete',function() {
		var tr = this.parentNode.parentNode;
		var td = tr.childNodes;
		var index = Number(tr.getAttribute('index'));
		var table = document.getElementById("cart-table");
		table.deleteRow(index+1);
		//删除表格后  session中的cart值需要改变  ajax请求
		//获取当前的b_id
		var id = tr.getAttribute('id')
		var ids=[]
		ids.push(id)
		var obj = {
			'ids':ids
		}
		 var r=confirm("确定删除？")
		  if (r==true)
		    {
			  $.ajax({
					url:'cart/deleteCart',
					contentType: "application/json; charset=utf-8",
					type:'post',
					data:JSON.stringify(obj),
					success:function(){
						$("#table_body").html("");
						getCartList()
					},
					error:function(){
						
					}
				})
		    }
		
		
	})
	//多条删除
	 $("body").on('click','.cart-multiDelete',function() {
		 let obj = {ids:multiDeleteArr}
			if(multiDeleteArr.length) {
				$.ajax({
					url:'cart/deleteCart',
					type:'post',
					contentType: "application/json; charset=utf-8",
					data:JSON.stringify(obj),
				
					success:function(){
						$("#table_body").html("");
						getCartList()
					},
					error:function(){
						
					}
				})
			}else{
				alert("请选择要删除的图书")
			}
		})
})

function getCartList(page,limit){
		if(!page) {
			page = 1
		}
		if(!limit) {
			limit = 10
		}
	$.ajax({
		url:'cart/initCart',
		type:'post',
		data:{
		  "page": page,
  		  "limit": limit,
		},
		success:function(data){
			totalPage = data.pageInfo.pages
			limit = data.pageInfo.pageSize
	    	currpage = data.pageInfo.pageNum
	    	$(".papigationPage").html("第"+currpage+"页/共"+totalPage+"页")
			var html = '';
			$.each(data.cartList,function(index,cdata){
				html +=	"<tr index="+index+" id="+cdata['cId']+"><td><input type=\"checkbox\" class=\"selectSub\" name="+cdata['bId']+"></td>"
				html += "<td><img class=\"table-img\" src=\"/book_images/"+cdata['bPic']+"\" /></td>"
				html += "<td class='bname'>"+cdata['bName']+"</td>"
				html += " <td class=\"cart-price\">"+cdata['bPrice']+"</td>"
				html += " <td class=\"dis_price\">"+cdata['bDiscountprice']+"</td>"
				html += " <td style=\"width: 120px;\">"
				html += "<input type=\"button\" value=\"-\" class=\"desc\"/>"
				html += " <input type=\"text\" value="+cdata['bNums']+" class=\"num-text\" name=\"book_num\" disabled=\"disabled\"/>"
				html += " <input type=\"button\" value=\"+\" class=\"plus\"/>"
				html += " </td>"
				html += "<td class=\"sum_money\">"+cdata['bSumdiscountprice']+"</td>"
				html += "<td style=\"width: 100px;\"><button class=\"cart-delete2 delete\">删除</button></td></tr>";
			});
			$("#table_body").html(html)
		},
		error:function(){
			
		}
		
	})
	
	$("body").on('click',".cart-submit",function(){
	  var obj = {}
	  selectedGoods = []
	  $("input:checkbox:checked").each(function(index,element){
		  if($(this).attr('name') == 'book-select'){
			  console.log('no need 表头不需要')
		  }else {
			  let cId = $(this).parent().parent().attr('id');
			  let bId = $(this).attr('name');
			  let imgSrc = $(this).parent().next().find(".table-img").attr('src');
			  let bname = $(this).parent().siblings().eq(1).html();
			  let bPrice =  $(this).parent().siblings().eq(2).html();
			  let bDiscountprice =  $(this).parent().siblings().eq(3).html();
			  let bNum = $(this).parent().siblings().eq(4).find(".num-text").val();
			  let bSumdiscountprice = $(this).parent().siblings().eq(5).html();
			  let bSumprice = bPrice * bNum
			  obj = {"cId":cId,"bId":bId,"imgSrc":imgSrc,"bName":bname,"bPrice":bPrice,"bDiscountprice":bDiscountprice,"bNum":bNum,"bSumdiscountprice":bSumdiscountprice,"bSumprice":bSumprice};
			  selectedGoods.push(obj)
		  }
	  })
	  if(multiDeleteArr.length && selectedGoods.length){
		  sessionStorage.setItem("selectedGoods",JSON.stringify(selectedGoods))
		  sessionStorage.setItem("selectedIds",JSON.stringify(multiDeleteArr))
		  setTimeout("javascript:location.href='confirmOrder.html'", 1000); 
	  }else {
		  alert("请选择商品")
	  }
	 
  })
}

//前台购物车中复选框中的全选与反选
$("#selectAll").click(function () {
  if (this.checked) {
    var sumPrice = 0;
    var m = document.getElementsByClassName("sum_money");
    for(var i = 0;i<m.length;i++){
    	sumPrice += Number(m[i].innerHTML);
    }
    var check = document.getElementsByClassName("selectSub");
    for(var i = 0;i<check.length;i++){
    	var flag2= false
    	if(multiDeleteArr.length){
			  for(var j=0;j<multiDeleteArr.length;j++){
				  if(check[i].getAttribute('name') ==multiDeleteArr[j]){
					  flag2=true;
					  break;
				  }
			  }
		  }
		  if(!flag){
			  multiDeleteArr.push(check[i].parentNode.parentNode.getAttribute('id')) 
		  }
    }
    $(".ac_money").html(sumPrice.toFixed(2));
    $(".selectSub").prop("checked", true);
    $(".selectSub").click(function () {
      getSumPrice()
    });
  } else {
	  multiDeleteArr = []
    var sum = 0.00;
    $(".selectSub").prop("checked", false);
    $(".ac_money").html(sum.toFixed(2));
  }
});

//计算总价
function getSumPrice(){
	var sum = 0.00,num=0;
	$(".selectSub").each(function(){
		if(this.checked == true){
			num +=1
			var no = this.parentNode.parentNode;
		    var td = no.childNodes;
			sum += Number(td[9].innerHTML)
		}else {
			$(".selectAll").prop("checked", false);
		}
	})

	if(num == $(".selectSub").length){
	   $(".selectAll").prop("checked", true);
	}
	$(".ac_money").html(sum.toFixed(2));
}

$("body").on('change','.selectSub',function(){
	getSumPrice()
})
	function toPage(str) {
			if(str == "index"){
				getCartList(1,limit)
			}
			if(str == "end") {
				getCartList(totalPage,limit)
			}
			if(str == "prev"){
				if(currpage>1) {
					getCartList(currpage-1,limit)
				}else {
					alert("已经是第一页")
					getCartList(1,limit)
				}
				
			}
			if(str == "next") {
				if(currpage < totalPage) {
					getCartList(currpage+1,limit)
				}else {
					alert("已经是最后一页")
					getCartList(totalPage,limit)
				}
			}
		}
	
	//是否为正整数  
  	function isPositiveNum(s){
    var re = /^[0-9]*[1-9][0-9]*$/ ;  
    return re.test(s)  
	} 
	
  	$("#pageSize").blur(function(){
  		var size = $("#pageSize").val()
  		if(isPositiveNum(size)) {
  			limit = Number(size)
  	  		getCartList(1,limit)
  		}else {
  			alert("请输入大于0的整数值")
  		}
  	})


