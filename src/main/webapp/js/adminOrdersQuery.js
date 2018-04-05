var Ocode='',totalPage=0,currpage=0,limit
var selectedValue = '',searchInput=""
	var multiDeleteArr = []
$(function(){
	getLists()
	 $("body").on('click','.cart-multiDelete',function() {
		 let obj = {ids:multiDeleteArr}
		 console.log(obj)
			if(multiDeleteArr.length) {
				$.ajax({
					url:'orders/deleteOrders',
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
				alert("请选择要删除的订单")
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
	    $("body").on('click','.order_delete',function() {
    	var obj = {
			'ids':[$(this).parent().attr('name')]
		}
    	 var r=confirm("确定删除该订单记录？")
    	  if (r==true)
    	    {
    		  $.ajax({
    				url:'orders/deleteOrders',
    				contentType: "application/json; charset=utf-8",
    				type:'post',
    				data:JSON.stringify(obj),
    				success:function(){
    					$(".book_lists").html("");
						getLists()
    				},
    				error:function(){
    					
    				}
    			}) 
    	    }
	})
	selectedValue = $("#search_con").val()
	$("#search_con").change(function(){
		$("#search_input").val('')
	  selectedValue = $("#search_con").val()
	})
	$("#search_button").click(function(){
		searchInput = $("#search_input").val()
		if(selectedValue && searchInput){
			if(selectedValue == "o_code") {
				Ocode = searchInput
			}
			getLists()
		}else{
			alert("请选择搜索条件")
		}
	})
})
function getLists(page,limit){
	if(!page) {
		page = 1
	}
	if(!limit) {
		limit = 10
	}
	
	$.ajax({
    	url:'orders/saleOrderQuery',
    	type:'post',
    	data:{ 
    		"page": page,
    		"limit": limit,
    		"oId":Ocode
    	},
    	success:function(data){
    		 totalPage = data.pageInfo.pages
    		  limit = data.pageInfo.pageSize
    		  currpage = data.pageInfo.pageNum
    		  $(".papigationPage").html("第"+currpage+"页/共"+totalPage+"页")
    		var html = ""
    		$.each(data.orderList,function(index,odata){
    	    		html += " <div class=\"order-container\">"
    	    		html += " <div class=\"order-top\">"
    	    		html += "<div class=\"order-top-left\">"
    	    		html += "<div><input type='checkbox'class='selectSub' name="+odata['oId']+">订单编号：<span>"+odata['oId']+"</span></div>"
    	    		html += "<div>订单时间：<span>"+odata['oTime']+"</span></div>"
    	    		html += " <div>收货人：<span>"+odata['uReceiver']+"</span></div></div>"
    	    		html += "<div class=\"order-top-right\"><div>等待付款</div></div></div>"
    	    		html += "<div class=\"order-content\"><div class=\"order-content-detail\">"
    	    		$.each(odata.orderDetailsList,function(index,ddata){
    	    			html += "<div class=\"detail-list-item\">"
    	    	    	html += "<img src=\"img/book_images/"+ddata['bPic']+"\">"
    	    	    	html += "<span class=\"order-content-detail-bookname\">"+ddata['bName']+"</span>"
    	    			html +="<div class=\"order-content-detail-right\">"
    	    			html += " <span class=\"order-content-detail-bookprice\">"+ddata['bSumdiscountprice']+"</span>"
    	    			html += "<span class=\"order-content-detail-bookoldprice\">"+ddata['bSumprice']+"</span>"
    	    			html += "<span class=\"order-content-detail-booknum\">"+ddata['bNums']+"</span>"
    	    			html += "</div> </div>";
    	    			html +=" <div class=\"clear\"></div>"
    	    		})
    	    		html +="</div> </div>"
    	    		html +=" <div class=\"order-bottom\">";
    	    		html += "<div name="+odata['oId']+"><input type=\"button\" value=\"删除\" class=\"pass_button order_delete\" style=\"width:100px;height:26px;line-height:26px\"></div>";
                	html += "<div>共"+odata['oNum']+"件商品&nbsp;&nbsp;合计：¥"+odata['oPrice']+"</div></div></div> ";
                
    	    	});
    	    	$("#mine_order_lists").html(html)
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