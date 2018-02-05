$(function(){
  //前台---------
  //前台购物车中复选框中的全选与反选
  $("#selectAll").click(function () {
    if (this.checked) {
      var num = 0,n=0;
      var m = document.getElementsByClassName("sum_money");
      for(var i = 0;i<m.length;i++){
        num += Number(m[i].innerHTML);
      }
      //alert(this.checked);
      $(".ac_money").html(num.toFixed(2));
      $(".selectSub").prop("checked", true);

      $(".selectSub").click(function () {
        $(".selectAll").prop("checked", false);

        var no = this.parentNode.parentNode;
        //alert(no);
        var td = no.childNodes;
        //alert(td[11].innerHTML);
        /*var shu = td[11].childNodes;
        //alert(shu[3].value);
        shu[3].value = 0;*/
        //alert(td[13].innerHTML);
        n = Number(num) - Number(td[13].innerHTML);

        $(".ac_money").html(n.toFixed(2));

      });

    } else {
      //alert(this.checked);
      var r = 0.00;
      $(".selectSub").prop("checked", false);
      $(".ac_money").html(r.toFixed(2));
    }
  });


  //购物车  当所有子复选框都选中  总的复选框也同样选中
  $(".selectSub").change(function () {
    $(".selectAll").prop("checked", false);
    var total = 0;
    var compare = 0,n = 0;
    $(".selectSub").each(function () {
      compare += 1;
      if (this.checked) {
        total += 1;
        var no = this.parentNode.parentNode;
        var td = no.childNodes;
        n += Number(td[13].innerHTML);
      }
    });
    if (total == compare) {
      $(".selectAll").prop("checked", true);

    }
    $(".ac_money").html(n.toFixed(2));
  });

  //购物车中的增加和减少数量的功能
  $(".plus").click(function(){
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

  })

  //购物车中的增加和减少数量的功能
  $(".desc").click(function(){
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
  });





  //后台管理员
	//js全选功能
	$("#choseAll").click(function(){
		//当状态是选中时
		if($(this).is(':checked')){
			$('input:checkbox').each(function() {
		        $(this).attr('checked', true);
			});
		}else{
			$('input:checkbox').each(function() {
		        $(this).attr('checked', false);
			});
		}
	});

	var flag=0;
	function deleteBook(id){
		$.ajax({
			url:'deleteBook?id='+id,
			type:"get",
			async: false,
			success:function(data){
				if(data=="success"){
					//alert("删除成功");
					flag=1;
				}
				else if(data=="fail"){
					alert("失败！！！！！");
				}
			},
			error:function(XMLHttpRequest,textStatus, errorThrown){
	       	 alert(XMLHttpRequest.status);//200正常响应
	         alert(XMLHttpRequest.readyState);//4处理状态正常接收
	         alert(XMLHttpRequest.responseText);//返回响应文本
	         alert(textStatus);
	     }
		});
	}

	//单个删除
	$(".singleDelete").click(function(){
		var b_id=this.name;
		deleteBook(b_id);
		if(flag==1){
		//删除成功后页面跳转
		location.href ="booksList"; 
		}
	})


	//多个删除
	$("#mulDelete").click(function(){
		$('input:checkbox').each(function() {
	        if($(this).is(':checked')){
	        	var temp=$(this).val();
	        	//alert(temp);
	        	deleteBook(temp);
	        }
		});
		location.href="booksList";
	});

	//增加输入图书信息验证
	function checkBookId(){
		var inputId=$("#b_id").val();
		$.ajax({
			type:'get',
			url:'booksIdCheck',
			data:inputId,
			success:function(data){
				if(data=="exit"){
					alert("id已经存在，请重新输入");
				}
			},
			error:function(){
			}
		});
	}



    

    
    //点击编辑的按钮
    $(".edit-text").click(function() {
    var title = this.title.trim();
		var tr = this.parentNode.parentNode;
		var td = tr.childNodes;
		var price = td[7].innerHTML.trim();
		var dis_price = td[9].innerHTML.trim();
		var inputs = td[11].childNodes;
		if(checkYN(inputs[1])){
			//完成编辑，存入数据库中
			inputs[3].disabled = true;
			inputs[1].style.display = "none";
			inputs[5].style.display = "none";
			this.value = "编辑";
			var v = inputs[3].value;
			cartRequest = createRequest();
			var url = "cartservlet?number="+v+"&b_id="+title+"&price="+price+"&dis_price="+dis_price;
			cartRequest.open("GET",url, true);
			cartRequest.onreadystatechange = cartHandle;
			cartRequest.send(null);

		}else{
			//开始编辑
			inputs[3].disabled = false;
			inputs[1].style.display = "inline";
			inputs[5].style.display = "inline";
			this.value = "完成";
		}

	})
	
	//检验 数据库的数量是否在编辑的状态
	function checkYN(ele) {
    	//alert(ele.style.dispaly);
		if(ele.style.display=="inline"){
			return true;
		}
		if(ele.style.display=="none"){
			return false;
		}
	}
    
    
    //ajax异步请求对象 
    function createRequest(){
    	try {
    		var request = new XMLHttpRequest();
    	} catch (tryMS) {
    		try {
    			request = new ActiveXObject("Msxml2.XMLHTTP");
    		} catch (otherMS) {
    			try {
    				request = new ActiveXObject("Microsoft.XMLHTTP");
    			} catch (failed) {
    				request = null;
    			}
    		}
    	}
    	return request;
    }
    
    function cartHandle() {
    	if(cartRequest.readyState==4){
			if(cartRequest.status==200){
				if(cartRequest.responseText.trim()=="okay"){
					//alert("写入session成功");
				}
			}
		}
	}


    //购物车中的删除
    $(".delete").click(function() {
		var tr = this.parentNode.parentNode;
		var td = tr.childNodes;
		//alert(tr.title);
		var index = Number(tr.title);
		var table = document.getElementById("cart-table");
		table.deleteRow(index+1);
		//删除表格后  session中的cart值需要改变  ajax请求
		//获取当前的b_id
		b_idImg = td[3].childNodes;
		var s = b_idImg[0].src;
		var str = s.split("/");
		var b_ida = str[str.length-1];
		var b_idb = b_ida.split(".");
		var b_id = b_idb[0];
		//alert(b_id);
		deleteRequest = createRequest();
		var url = "delete?b_id="+b_id;
		deleteRequest.open("GET",url,true);
		deleteRequest.onreadystatechange = deletehandler;
		deleteRequest.send(null);
		
	})
	
	
	function deletehandler() {
		if(deleteRequest.readyState==4){
			if(deleteRequest.status==200){
				console.log("删除成功");
			}
		}
	}
})


