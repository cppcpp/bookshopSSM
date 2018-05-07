
$(function(){
  $("#testimonial-slider").owlCarousel({
      items: 3,
      navigation: true,
      navigationText: ["",""],
      dataType : 'jsonp',
  	  jsonp: 'jsonpCallback',
      jsonPath : 'initIndexPage',
      jsonSuccess : customDataSuccess,
      autoPlay: true,
      singleItem: true
});
//获取首页4个模块信息
$.ajax({
	  url:"initIndexPage",
	  method:"get",
	  dataType:"json",
	  success:function(data){
		  var newsethtml = ""
			  if(data.recommendFourBooks && data.recommendFourBooks.length) {
				$.each(data.recommendFourBooks,function(index,ndata){
					newsethtml += "<li><a href=\"detail.html?bId="+ndata['bId']+"\">"
					newsethtml += "<div class=\"block\">";
					newsethtml += " <h4 class=\"counter\">"+ndata['bName']+"</h4>"
					newsethtml += " <span> <img src=\"/book_images/"+ndata['bPic']+"\" alt=\"Pepole\"></span>"
					newsethtml += "</div></a></li>"
				})
				$(".counter-box").append(newsethtml);
		  }else{
			  console.log('暂无推荐')
			$(".counter-box").append('暂无推荐');
		  }
		  var tab1 = '',tab2 = ''
		  if(data.bestSaleFourBooks || data.discountFourBooks) {
			  $.each(data.bestSaleFourBooks,function(index,ndata){
				tab1 += "<div class=\"col-sm-6 col-md-3\"> <div class=\"service-item\">"
				tab1 += " <img src=\"/book_images/"+ndata['bPic']+"\" alt=\"Pepole\">"
				tab1 += "<h4>"+ndata['bName']+"</h4>"
				tab1 += " <p>"+ ndata['bDescription']+"</p>"
				tab1 += "<p><a href=\"detail.html?bId="+ndata['bId']+"\">-详情-</a></p>"
				tab1 += "</div></div>"
			})
			 $.each(data.discountFourBooks,function(index,ndata){
				tab2 += "<div class=\"col-sm-6 col-md-3\"> <div class=\"service-item\">"
				tab2 += "<img src=\"/book_images/"+ndata['bPic']+"\">"
				tab2 += "<h4>"+ndata['bName']+"</h4>"
				tab2 += " <p>"+ ndata['bDescription']+"</p>"
				tab2 += "<p><a href=\"detail.html?bId="+ndata['bId']+"\">-详情-</a></p>"
				tab2 += "</div></div>"
			}) 
			$(".tab1").append(tab1);
			$(".tab2").append(tab2);
		  }
		
	  },
	  error:function(){
	  }
});
$(".tabbox .tab a").mouseover(function(){
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();
		$('.tabbox .ctx li').hide();
		$('.tabbox .ctx li:eq('+index+')').show();
	});
})

function customDataSuccess(data){
	  var owlhtml = ""
	  if(data.newsetThreeBooks) {
				$.each(data.newsetThreeBooks,function(index,ndata){
					owlhtml += "<div><a href=\"detail.html?bId="+ndata['bId']+"\"> <img src='img/new.png' alt='IMG'><p>"+ndata['bDescription']+"</p>"
					owlhtml += "<div class=\"user\">"
					owlhtml += " <img src=\"/book_images/"+ndata['bPic']+"\" alt=\"Pepole\">"
					owlhtml += " <p><span>"+ndata['bName']+"</span>"+ ndata['bAuthor']+"</p>"
					owlhtml += "</div></a></div>"
						$("#testimonial-slider").html(owlhtml);
				})
		  }
}