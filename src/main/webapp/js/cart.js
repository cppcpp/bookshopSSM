$(function(){
	
	getCartList()
	var multiDeleteArr = []
	var flag = false
  $("body").on("click",".selectSub",function(){
	  currentName = this.getAttribute('name')
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
    console.log(sum_money)
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
			'ids':JSON.stringify(ids)
		}
		$.ajax({
			url:'cart/deleteCart',
			contentType: "application/json; charset=utf-8",
			type:'post',
			data:JSON.stringify(obj),
			success:function(){
				
			},
			error:function(){
				
			}
		})
	})
	 $("body").on('click','.cart-multiDelete',function() {
			if(multiDeleteArr.length) {
				$.ajax({
					url:'cart/deleteCart',
					type:'post',
					contentType: "application/json; charset=utf-8",
					data:{
						ids:JSON.stringify(multiDeleteArr)
					},
					success:function(){
						
					},
					error:function(){
						
					}
				})
			}else{
				alert("请选择要删除的图书")
			}
		})
})

function getCartList(){
	$.ajax({
		url:'cart/cartQry',
		type:'get',
		/*data:{
			'uAccount':uAccount
		},*/
		success:function(data){
			var html = ''
			$.each(data.cartList,function(index,cdata){
				html +=	"<tr index="+index+" id="+cdata['bId']+"><td><input type=\"checkbox\" class=\"selectSub\" name="+cdata['bId']+"></td>"
				/*html += "<td><img class=\"table-img\" src=\"img/book_images/"+cdata['bPic']+"></td>"*/
				html += "<td><img class=\"table-img\" src='img/book_images/a2.jpg'></td>"
				html += "<td>"+cdata['bName']+"</td>"
				html += " <td class=\"cart-price\">"+cdata['bPrice']+"</td>"
				html += " <td class=\"dis_price\">"+cdata['bDiscountprice']+"</td>"
				html += " <td style=\"width: 120px;\">"
				html += "<input type=\"button\" value=\"-\" class=\"desc\"/>"
				html += " <input type=\"text\" value="+cdata['bNums']+" class=\"num-text\" name=\"book_num\" disabled=\"disabled\"/>"
				html += " <input type=\"button\" value=\"+\" class=\"plus\"/>"
				html += " </td>"
				html += "<td class=\"sum_money\">"+cdata['bSumdiscountprice']+"</td>"
				html += "<td style=\"width: 100px;\"><button class=\"cart-delete2 delete\">删除</button></td></tr>"
			})
			$("#table_body").append(html)
		},
		error:function(){
			
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
    $(".ac_money").html(sumPrice.toFixed(2));
    $(".selectSub").prop("checked", true);
    $(".selectSub").click(function () {
      getSumPrice()
    });
  } else {
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


