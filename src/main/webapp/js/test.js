$(function(){
	var test={ids:[]}
	test.ids.push("123")
	
	//var test1=JSON.stringify({'ids':["123","343"]})
	var test1=JSON.stringify(test)
  //删除购物车数据测试
  $.ajax({
  	url:"cart/deleteCart",
  	method:"post",
  	contentType:"application/json;charset=utf-8",
  	data:test1,
  	success:function(data){
  		alert(data)
  	}
  });
		
	
})