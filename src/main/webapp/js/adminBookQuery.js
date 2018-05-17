var bAuthor='',category='',bPress='',bName='',totalPage=0,currpage=0,limit
var selectedValue = '',searchInput=""
	var multiDeleteArr = []
$(function(){
	getLists()
	$("body").on('click','.cart-multiDelete',function() {
		 let obj = {ids:multiDeleteArr}
			if(multiDeleteArr.length) {
				$.ajax({
					url:'books/deleteBooks',
					type:'post',
					contentType: "application/json; charset=utf-8",
					data:JSON.stringify(obj),
					success:function(data){
						if(data.indexOf("success")!= -1) {
						 $("#tip-success-show-admin").css("display", "block")
					     $(".tip-content").html("删除成功")						 
						 setTimeout(function(){
							  $("#tip-success-show-admin").css("display", "none")
							  $(".book_lists").html("");
							  $("body").css({overflow:"auto"});
							  getLists()
						 },2000) 
					}else {
						 $(".tip-content").html("删除失败")
						 $("#tip-failure-show-admin").css("display", "block")
						  setTimeout(function(){
							  $("#tip-success-show-admin").css("display", "none")
							  $(".book_lists").html("");
							  $("body").css({overflow:"auto"});
							  getLists()
						 },2000) 
					 }
						
					},
					error:function(){
						$(".tip-content").html("删除失败")
						 $("#tip-failure-show-admin").css("display", "block")
						  setTimeout(function(){
							  $("#tip-success-show-admin").css("display", "none")
							  $(".book_lists").html("");
							  $("body").css({overflow:"auto"});
							  getLists()
						 },2000) 
					}
				})
			}else{
				alert("请选择要删除的图书")
			}
		})
	$("#selectAll").click(function () {
		if (this.checked) {
		var check = document.getElementsByClassName("selectSub");
	    for(var i = 0;i<check.length;i++){
	    	var flag= false
	    	if(multiDeleteArr.length){
				  for(var j=0;j<multiDeleteArr.length;j++){
					  if(check[i].getAttribute('name') ==multiDeleteArr[j]){
						  flag=true;
						  break;
					  }
				  }
			  }
			  if(!flag){
				  multiDeleteArr.push(check[i].getAttribute('name')) 
			  }
	    }
    $(".selectSub").prop("checked", true);
    $(".selectSub").click(function () {
    	var num=0
    	$(".selectSub").each(function(){
    		if(this.checked == true){
    			num +=1
    			var no = this.parentNode.parentNode;
    		    var td = no.childNodes;
    		}else {
    			$("#selectAll").prop("checked", false);
    		}
    	})
    	if(num == $(".selectSub").length){
    		   $("#selectAll").prop("checked", true);
    		}
      });
  } else {
	  multiDeleteArr = []
	  $(".selectSub").prop("checked", false);
  }
});
	
	 $("body").on("click",".selectSub",function(){
		 var num=0
	    	$(".selectSub").each(function(){
	    		if(this.checked == true){
	    			num +=1
	    			var no = this.parentNode.parentNode;
	    		    var td = no.childNodes;
	    		}else {
	    			$("#selectAll").prop("checked", false);
	    		}
	    	})
	    	if(num == $(".selectSub").length){
	    		   $("#selectAll").prop("checked", true);
	    		}
		  currentName = $(this).attr("name");
		  let flag = false;
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
	
	selectedValue = $("#search_con").val()
	$("#search_con").change(function(){
	  bAuthor='',category='',bPress='',bName=''
	  $("#search_input").val('')
	  selectedValue = $("#search_con").val()
	})
	$("#search_button").click(function(){
		bAuthor='',category='',bPress='',bName=''
		searchInput = $("#search_input").val()
		if(selectedValue && searchInput){
			if(selectedValue == "b_name") {
				bName = searchInput
			}else if(selectedValue == "b_press"){
				bPress = searchInput
			}else if(selectedValue == "b_author"){
				bAuthor = searchInput
			}else if(selectedValue == "b_category"){
				category = searchInput
			}
			switch(category){
			case '马列主义、毛泽东思想':
				category = 'a'
			   break;
			case '哲学':
				category = 'b'
			   break;
			case '社会科学':
				category =  'c'
			   break;
			case '政治法律':
				category =  'd'
			   break;
			case '军事':
				category =  'e'
			   break;
			case '经济':
				category =  'f'
			   break;
			case '文化、科学、教育、体育':
				category =  'g'
			   break;
			case '语言、文字':
				category = 'h'
			   break;	
			case '文学':
				category = 'i'
			   break;
			case '艺术':
				category =  'j'
			   break;
			case '历史、地理':
				category =  'k'
			   break;
			case '自然科学总论':
				category = 'n'
			   break;
			case '数理科学和化学':
				category =  'o'
			   break;
			case '天文学、地球科学':
				category =  'p'
			   break;
			case '生物科学':
				category =  'q'
			   break;
			case '医药、卫生':
				category =  'r'
			   break;
			case '农业科学':
				category =  's'
			   break;
			case '工业科学':
				category =  't'
			   break;
			case '交通运输':
				category =  'u'
			   break;
			case '航天航空':
				category =  'v'
			   break;
			case '环境科学':
				category =  'x'
			   break;
			case '综合性图书':
				category =  'z'
			   break;
			}
			getLists()
		}else{
			alert("请选择搜索条件")
		}
	})
	//修改
    $("body").on("click",".singleModify",function(){
        $("#div2").slideDown();
        document.getElementById("bg").style.display ="block";
        $("body").css({overflow:"hidden"})
        var b_id=$(this).attr("name");
        console.log(b_id)
        var ul = $(this).parent().parent().find("ul")
        console.log(ul)
        var ulchilds=ul.children();
      
       for(var i=0;i<ulchilds.length;i++){
    	   if(ulchilds[i].tagName=="LI"){
               assignment(ulchilds[i]);
           }
       }
    });
	$("body").on("click",".singleDelete",function(){
        var b_id=$(this).attr("name");
        let ids = [];
        ids.push(b_id)
        var r = confirm("确定删除该书籍？")
        if(r == true){
        	 $.ajax({
				  url:'books/deleteBooks',
				  type:'post',
				  contentType: "application/json; charset=utf-8",
				  data:JSON.stringify({
					  "ids":ids
				  }),
				  success:function(data){
					  if(data.indexOf("success")!= -1) {
							 $("#tip-success-show-admin").css("display", "block")
						     $(".tip-content").html("删除成功")						 
							 setTimeout(function(){
								  $("#tip-success-show-admin").css("display", "none")
								  $(".book_lists").html("");
								  $("body").css({overflow:"auto"});
								  getLists()
							 },2000) 
						}else {
							 $(".tip-content").html("删除失败")
							 $("#tip-failure-show-admin").css("display", "block")
							  setTimeout(function(){
								  $("#tip-success-show-admin").css("display", "none")
								  $(".book_lists").html("");
								  $("body").css({overflow:"auto"});
								  getLists()
							 },2000) 
							
						 }
					 
				  }
			  })
        }
       
    });
    //给input的相应节点赋值
    function assignment(thNode){
        var input=document.getElementsByTagName("input");
        for(var k=0;k<input.length;k++){
            var name=input[k].name;
            if(name==thNode.title){
                input[k].value=thNode.lastChild.nodeValue;
            }
        }
    }
})
function getLists(page,limit){
	if(!page) {
		page = 1
	}
	if(!limit) {
		limit = 10
	}
	
	$.ajax({
		url:'books/booksQry',
		method:'get',
		 data:{
		  "bId":category, 
		  "page": page,
		  "limit": limit,
		  "bAuthor":bAuthor,
		  "bPress":bPress,
		  "bName":bName
   	  },
		success:function(data) {
			 totalPage = data.pageInfo.pages;
   		  	 limit = data.pageInfo.pageSize;
   		  	 currpage = data.pageInfo.pageNum;
   		  $(".papigationPage").html("第"+currpage+"页/共"+totalPage+"页");
		  var html = "";
   		  $.each(data.books,function(index,bdata){
   			  html += "<div class=\"book\">";
   			  html += "<div class=\"book_column book_column_one\">"
   			  html += " <input class=\"selectSub\" type='checkbox' name="+bdata['bId']+">"
   			  html += "</div>"
   			  html += "<div class=\"book_column book_column_two\">"
   			  html += "<div><img src=\"/book_images/"+bdata['bPic']+"\"></div></div>"
   			  html += "<div class=\"book_column book_column_three\">"	
   			  html += "<ul>"
   			  html += "<li title=\"bId\"  class=\"li_book\"><b>Id：</b>"+bdata['bId']+"</li><br>"
   			  html += "<li title=\"bName\"  class=\"li_book\"><b>名称：</b>"+bdata['bName']+"</li><br>"
   			  html += "<li title=\"bDescription\" class=\"li_book\"><b>图书描述：</b>"+bdata['bDescription']+"</li><br>"
   			  html += "<li title=\"bPrice\" class=\"li_book\"><b>价格：</b>"+bdata['bPrice']+"</li><br>"
   			  html += "<li title=\"bDiscount\" class=\"li_book\"><b>折扣：</b>"+bdata['bDiscount']+"</li><br>"
   			  html += "<li title=\"bAuthor\" class=\"li_book\"><b>作者：</b>"+bdata['bAuthor']+"</li><br>"
  			  html += "<li title=\"bPress\" class=\"li_book\"><b>出版社：</b>"+bdata['bPress']+"</li><br>"
  			  html += "<li title=\"bPressTime\" class=\"li_book\"><b>出版时间：</b>"+bdata['bPressTime']+"</li><br>"
 			  html += "<li title=\"bService\" class=\"li_book\"><b>上架时间：</b>"+bdata['bService']+"</li><br>"
 			  html += "<li title=\"bNum\" class=\"li_book\"><b>已售数量：</b>"+bdata['bSaleNum']+"</li><br>"
			  html += "<li title=\"bTime\" class=\"li_book\"><b>上架时间：</b>"+bdata['bAddTime']+"</li><br>"
 			  html += "</ul></div>"
 			  html += "<div class=\"book_column book_column_four\">"
 			  html += "<input type=\"button\" value=\"删除\" name="+bdata['bId']+" class=\"singleDelete\">"
 			  html += "<input type=\"button\" value=\"修改\" class=\"singleModify\" name="+bdata['bId']+">"
   			  html += "</div></div><br>";
 				
   		  });
   		  $(".book_lists").html(html)
		}
	})
}
function toPage(str) {
	console.log(str)
	if(str == "index"){
		getLists(1,limit)
	}
	if(str == "end") {
		getLists(totalPage,limit)
	}
	if(str == "prev"){
		if(currpage>1) {
			getLists(currpage-1,limit)
		}else {
			alert("已经是第一页")
			getLists(1,limit)
		}
		
	}
	if(str == "next") {
		if(currpage < totalPage) {
			getLists(currpage+1,limit)
		}else {
			alert("已经是最后一页")
			getLists(totalPage,limit)
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
	  		getLists(1,limit)
		}else {
			alert("请输入大于0的整数值")
		}
	})