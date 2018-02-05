/**
 * ztchun
 */

$(function(){
	//图书详细信息  增加和减少图书
    var inp = document.getElementById("num_text");
    var b_id = document.getElementById("b_id_text");
    //var add_cart = document.getElementById("add_cart");
    //add_cart.onclick = alert("dfsd");
	$(".desc").click(function() {
		value = Number(inp.value);
		value -= 1;
		if(value<1){
			value = 1;
		}
		inp.value = value;
	})
	
	$(".plus").click(function() {
		value = Number(inp.value);
		value += 1;
		if(value<1){
			value = 1;
		}
		inp.value = value;
	})
	
	//获取图书信息  准备存入数据库cart数据表中
	$("#add_cart").click(function() {
		//alert("加入购物车");
		detailsRequest = createRequest();
		var url = "detailsCart?num="+Number(inp.value)+"&b_id="+b_id.value;
		detailsRequest.open("GET",url,true);
		detailsRequest.onreadystatechange = detailHandler;
		detailsRequest.send(null);
	})
	
	function detailHandler() {
		if(detailsRequest.readyState==4){
			if(detailsRequest.status==200){
				//console.log("添加成功");
//				alert("添加成功");
				if(detailsRequest.responseText=="fail"){
					alert("你还没有登录,将为你跳转到登录页面");
					window.location = "login.jsp";
				}else{
					alert("添加成功");
				}
			}
		}
	}
	
	//立即购买
	$("#now_order").click(function() {
		//alert("立即购买");
		form1.submit();
		/*orderRequest = createRequest();
		var url = "detailsOrder?num="+Number(inp.value)+"&b_id="+b_id.value;
		orderRequest.open("GET",url,true);
		orderRequest.onreadystatechange = orderDetailsHandler;
		orderRequest.send(null);*/
	})
	
	
	/*function orderDetailsHandler() {
		if(orderRequest.readyState==4){
			if(orderRequest.status==200){
				alert("下单成功");
				window.location = "order.jsp";
			}
		}
	}*/
	
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
	
	
})