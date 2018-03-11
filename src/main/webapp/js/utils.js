/**
 * 
 */
$(function() {
	$.ajax({
		  url:'user/loginUAccount',
		  method:"get",
		  success:function(data){
			  if(data != 'empty' ) {
				  console.log(data)
				  $("#top-bar").html("<li style=\"width:80px\">你好，"+data+"</li><li><a href='user/logOut'>退出</a></li>")
			  }
		 }
	  })
	  $.ajax({
		  url:'cart/countOfCart',
		  method:"get",
		  success:function(data){
			  if(data != 'userNotExitsError' && data != 0){
				  $('.nav-cart-area').append("<span class=\"cart-num\">"+data+"</span>")
			  }else {
				  $('.nav-cart-area').append("<span class=\"cart-num\" style=\"background:white;z-index:0\"></span>")
			  }
		 }
	  })
	  
	  
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