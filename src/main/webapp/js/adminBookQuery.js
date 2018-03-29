var bAuthor='',category='',bPress='',bName='',totalPage=0,currpage=0,limit
var selectedValue = '',searchInput=""

$(function(){
	getLists()
	selectedValue = $("#search_con").val()
	$("#search_con").change(function(){
	  selectedValue = $("#search_con").val()
	})
	$("#search_button").click(function(){
		searchInput = $("#search_input").val()
		console.log(selectedValue,searchInput)
		if(selectedValue && searchInput){
			console.log(selectedValue,searchInput)
			if(selectedValue == "b_name") {
				bName = searchInput
			}else if(selectedValue == "b_press"){
				bPress = searchInput
			}else if(selectedValue == "b_author"){
				bAuthor = searchInput
			}else if(selectedValue == "b_category"){
				category = searchInput
			}
			getLists()
		}else{
			alert("请选择搜索条件")
		}
	})
	//修改
    $("body").on("click",".singleModify",function(){
        $("#div2").slideDown();
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
     //
    });
	$("body").on("click",".singleDelete",function(){
        var b_id=$(this).attr("name");
        console.log("###",b_id);
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
					  console.log(data)
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
   		  "category":category, 
   		  "page": page,
   		  "limit": limit,
   		  "bAuthor":bAuthor,
   		  "bPress":bPress,
   		  "bName":bName
   	  },
		success:function(data) {
			console.log(data)
			 totalPage = data.pageInfo.pages
   		  	 limit = data.pageInfo.pageSize
   		  	 currpage = data.pageInfo.pageNum
   		  $(".papigationPage").html("第"+currpage+"页/共"+totalPage+"页")
		  var html = "";
   		  $.each(data.books,function(index,bdata){
   			  html += "<div class=\"book\">";
   			  html += "<div class=\"book_column book_column_one\">"
   			  html += " <input type='checkbox' value="+bdata['bId']+"/>"
   			  html += "</div>"
   			  html += "<div class=\"book_column book_column_two\">"
   			  html += "<div><img src=\"img/book_images/"+bdata['bPic']+"\"></div></div>"
   			  html += "<div class=\"book_column book_column_three\">"	
   			  html += "<ul>"
   			  html += "<li title=\"bName\"  class=\"li_book\"><b>名称：</b>"+bdata['bName']+"</li><br>"
   			  html += "<li title=\"bDescription\" class=\"li_book\"><b>图书描述：</b>"+bdata['bDescription']+"</li><br>"
   			  html += "<li title=\"bPrice\" class=\"li_book\"><b>价格：</b>"+bdata['bPrice']+"</li>"
   			  html += "<li title=\"bDiscount\" class=\"li_book\"><b>折扣：</b>"+bdata['bDiscount']+"折</li><br>"
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
   			  html += "</div></div><br>"
 				
   		  })
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