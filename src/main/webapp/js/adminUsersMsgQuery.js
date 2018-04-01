var uAccount='',uPhone='',uRole='',totalPage=0,currpage=0,limit
var selectedValue = '',searchInput=""
	var multiDeleteArr = []
$(function(){
	getLists()
 $("body").on('click','.cart-multiDelete',function() {
		 let obj = {ids:multiDeleteArr}
		 console.log(obj)
			if(multiDeleteArr.length) {
				$.ajax({
					url:'userMessage/deleteUserMessage',
					type:'post',
					contentType: "application/json; charset=utf-8",
					data:JSON.stringify(obj),
				
					success:function(){
						$(".book_lists").html("");
						getLists()
					},
					error:function(){
						
					}
				})
			}else{
				alert("请选择要删除的用户留言")
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
    	console.log(num,$(".selectSub").length)
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
	    	console.log(num,$(".selectSub").length)
	    	if(num == $(".selectSub").length){
	    		   $("#selectAll").prop("checked", true);
	    		}
	
		  currentName = $(this).attr("name");
		  console.log(currentName);
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
	
	//delete
	 $("body").on("click",".singleDelete",function(){
		let id = $(this).attr("name");
		let ids = []
		ids.push(id)
		 var r=confirm("确定删除该用户信息？")
		  if (r==true)
		    {
			  $.ajax({
				  url:'userMessage/deleteUserMessage',
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
	
  
});

function getLists(page,limit){
	if(!page) {
		page = 1
	}
	if(!limit) {
		limit = 10
	}
	$.ajax({
		url:'userMessage/userMessageQry',
		method:'get',
		 data:{
   		  "uAccount":uAccount,
   		  "page": page,
   		  "limit": limit,
   		  "uPhone":uPhone,
   		  "uRole":uRole
   	  },
		success:function(data){
			console.log(data)
			 totalPage = data.pageInfo.pages
   		  	 limit = data.pageInfo.pageSize
   		  	 currpage = data.pageInfo.pageNum
   		  $(".papigationPage").html("第"+currpage+"页/共"+totalPage+"页")
		  var html = "";
		 $.each(data.userMessageList,function(index,udata){
				  html += "<div class=\"book\">";
				  html += "<div class=\"book_column book_column_one\">"
				  html += " <input type='checkbox'class='selectSub' name="+udata['uAccount']+">"
				  html += "</div>"
				  html += "<div class=\"book_column book_column_three\">"
				  html += "<ul>"
				  html += "<li title=\"user_name\"  class=\"li_book\"><b>账户：</b>"+udata['uAccount']+"</li><br>"
				  html += "<li title=\"user_name\"  class=\"li_book\"><b>留言：</b><br>"+udata['uMessage']+"</li><br>"
				  html += "</ul></div>"
				  html += "<div class=\"book_column book_column_four\">"
				  html += "<input type=\"button\" value=\"删除\" class=\"singleDelete\" name="+udata['uAccount']+">"
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