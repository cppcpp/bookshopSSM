$(function(){
	 $(document).ready(function () {
    $(".level1 > a").click(function () {
      if($(this).is(".current")){
        $(this).next().slideUp("slow");
        $(this).removeClass("current");
      }else{
        $(this).addClass("current")   /*给当前元素添加“当前”样式*/
          .next().slideDown("slow")   //下一个元素显示
          .parent().siblings().children("a").removeClass("current")  /*这句话执行好后当前this即为silbings 不再为本身了*/
          .next().slideUp("slow");   //她们下一个元素隐藏
      }
      return false;
    })
    $(".level2 > li").hover(function () {
      $(".level1 >a").css('textDecoration','none')
      return false;
    })
  })
  
  $.ajax({
		  url:'user/loginUAccount',
		  method:"get",
		  success:function(data){
			  console.log(data)
			  if(data != 'empty' ) {
				  $("。nav-right-area").html("<span style=\"width:80px\">你好，"+data+"</li><li><a href='user/logOut'>退出</a></span>")
			  }
		 }
	  })
  
  $.ajax({
		  url:'user/loginUAccount',
		  method:"get",
		  success:function(data){
			  if(data != 'empty' ) {
				  console.log(data)
				  $(".nav-right-area").html("<span>你好，"+data+"&nbsp;<a href='user/logOut'>退出</a></span>")
			  }
		 }
	  })
	  $(".circles").click(function() {
          $("#div2").slideUp();
          $("body").css({overflow:"auto"})
          document.getElementById("bg").style.display ="none";
      })
})
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