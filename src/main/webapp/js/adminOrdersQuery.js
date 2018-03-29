var Ocode='',totalPage=0,currpage=0,limit
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
    		"limit": limit
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
    	    		html += "<div>订单编号：<span>"+odata['oId']+"</span></div>"
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
    	    			html += "</div> </div>"
    	    			html +=" <div class=\"clear\"></div>"
    	    		})
    	    		html +="</div> </div>"
    	    		html +=" <div class=\"order-bottom\">"
    	    		html += "<div name="+odata['oId']+"><input type=\"submit\" value=\"删除\" class=\"pass_button order_delete\"></div>"
                	html += "<div>共"+odata['oNum']+"件商品&nbsp;&nbsp;合计：¥"+odata['oPrice']+"</div></div></div> "
                
    	    	})
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