$(function() {
	 $("#searchBtn").click(function(){
		  if($("#searchBook").val()!=""){
			  window.location="searchBook.html?data="+$("#searchBook").val()
		  }
	  })
	
	
	// 判断登录信息
	$.ajax({
		  url:'user/loginUAccount',
		  method:"get",
		  success:function(data){
			  if(data != 'empty' ) {
				  $("#top-bar").html("<li style=\"width:100px;\">你好，"+data+"</li><li><a href='user/logOut'>退出</a></li>")
			  }
		 }
	  })
	  
	  //购物车个数
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
	 //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
    $(function () {
      $(window).scroll(function(){
        if ($(window).scrollTop()>100){
          $("#back-to-top").fadeIn(1500);
        }
        else
        {
          $("#back-to-top").fadeOut(1500);
        }
      });

      //当点击跳转链接后，回到页面顶部位置
      $("#back-to-top").click(function(){
        //$('body,html').animate({scrollTop:0},1000);
        if ($('html').scrollTop()) {
          $('html').animate({ scrollTop: 0 }, 1000);
          return false;
        }
        $('body').animate({ scrollTop: 0 }, 1000);
        return false;
      });
    });
})
  //手机号码限制位数和数字
  function WidthCheck(str, maxLen){ 
	str.value=str.value.replace(/\D/g,'');
	var w = 0; 
	var tempCount = 0; 
	//length 获取字数数，不区分汉子和英文 
	for (var i=0; i<str.value.length; i++) { 
	//charCodeAt()获取字符串中某一个字符的编码 
	var c = str.value.charCodeAt(i); 
	//单字节加1 
	if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) { 
			w++; 
		} else { 
			w+=2; 
			} 
			if (w > maxLen) { 
			str.value = str.value.substr(0,i); 
			break; 
		} 
	} 
}