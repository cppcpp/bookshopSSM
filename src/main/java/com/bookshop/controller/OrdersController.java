package com.bookshop.controller;import java.text.SimpleDateFormat;
import java.util.ArrayList;import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import javax.servlet.http.HttpSession;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;import com.bookshop.modle.OrderDetail;import com.bookshop.modle.OrderDetailExample;import com.bookshop.modle.Orders;
import com.bookshop.modle.OrdersExample;import com.bookshop.modle.UserAddress;import com.bookshop.modle.UserAddressExample;import com.bookshop.modle.UserAddressExample.Criteria;import com.bookshop.modle.Users;import com.bookshop.service.CartService;import com.bookshop.service.OrderDetailService;import com.bookshop.service.OrdersService;import com.bookshop.service.UserAddressService;import com.bookshop.util.StringUtil;
import com.github.pagehelper.PageInfo;
@Controller@RequestMapping("/orders")public class OrdersController {
    @Autowired
    OrdersService ordersSV;        @Autowired    OrderDetailService orderDetailService;        @Autowired    HttpSession session;        @Autowired    UserAddressService userAdressService;        @Autowired    CartService cartService;

    @RequestMapping(value="/ordersQry",method=RequestMethod.GET)    @ResponseBody
    public Map ordersQry(
             @RequestParam(name="oId",required=false)String oId,
             @RequestParam(name="oNum",required=false)String oNum,
             @RequestParam(name="oPrice",required=false)String oPrice,
             @RequestParam(name="oTimeStart",required=false)String oTimeStart,
             @RequestParam(name="oTimeEnd",required=false)String oTimeEnd,
             @RequestParam(name="uAccount",required=false)String uAccount,
             @RequestParam(name="uAddress",required=false)String uAddress,
             @RequestParam(name="oPhone",required=false)String oPhone,
             @RequestParam(name="uReceiver",required=false)String uReceiver,
             @RequestParam(name="oCheaper",required=false)String oCheaper,
             @RequestParam(name="page",required=false)String page,@RequestParam(name="limit",required=false)String limit){    	Map<String,Object> resultMap=new HashMap<>();
        List<Map> mapList = new ArrayList<>();
        int pageNum =  page == null ? 1 : Integer.parseInt(page);
        int pageSize =  limit == null ? 10 : Integer.parseInt(limit);
        Map<String, String> ordersExmMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        List<OrderDetail> orderDetailsList;        
        ordersExmMap.put("oId", oId);
        ordersExmMap.put("oNum", oNum);
        ordersExmMap.put("oPrice", oPrice);
        ordersExmMap.put("oTimeStart", oTimeStart);
        ordersExmMap.put("oTimeEnd", oTimeEnd);
        ordersExmMap.put("uAccount", uAccount);
        ordersExmMap.put("uAddress", uAddress);
        ordersExmMap.put("oPhone", oPhone);
        ordersExmMap.put("uReceiver", uReceiver);
        ordersExmMap.put("oCheaper", oCheaper);
        OrdersExample example = ordersSV.createOrdersExm(ordersExmMap);
        List<Orders> ordersList = ordersSV.selectByExample(example,pageNum,pageSize);
        int total = ordersSV.countByExample(example);
        for (Orders orders : ordersList) {
            Map<String,Object> tMap = new HashMap<>();
            tMap.put("oId", orders.getoId());
            if(orders.getoNum()!=null){
                tMap.put("oNum", orders.getoNum().toString());
            }
            if(orders.getoPrice()!=null){
                tMap.put("oPrice", orders.getoPrice().toString());
            }
            if(orders.getoTime()!=null){
                tMap.put("oTime", sdf.format(orders.getoTime()));
            }
            tMap.put("uAccount", orders.getuAccount());
            tMap.put("uAddress", orders.getuAddress());
            tMap.put("oPhone", orders.getoPhone());
            tMap.put("uReceiver", orders.getuReceiver());
            if(orders.getoCheaper()!=null){
                tMap.put("oCheaper", orders.getoCheaper().toString());
            }            //订单中包含几本书--即订单详情	            OrderDetailExample orderDetailExample=new OrderDetailExample();            com.bookshop.modle.OrderDetailExample.Criteria criteria=orderDetailExample.createCriteria();            criteria.andOIdEqualTo(orders.getoId());            orderDetailsList=orderDetailService.selectByExample(orderDetailExample);            tMap.put("orderDetailsList", orderDetailsList);            mapList.add(tMap);
        }        resultMap.put("orderList", mapList);            //分页信息        PageInfo<Orders> pageInfo=new PageInfo<>(ordersList);        resultMap.put("pageInfo", pageInfo);        
       return resultMap;
    }
    //生成订单--前台传订单信息+订单详细信息    @RequestMapping(value="/addOrders",method=RequestMethod.POST)    @ResponseBody
    public String addOrders(@RequestBody Map<String, Object>req){    	//购物车id列表    	List<String> idList = (List<String>) req.get("ids");    	String strSuc = "";        String strFail = "";        String strNotExist = "";     	    	Orders orders=new Orders();    	String id=null, uAccount=null,oNum=null,oPrice=null,oCheaper=null,uAddress=null,oPhone=null,uReceiver=null;    	if(req.get("oId")!=null) {    		id = req.get("oId").toString();    	}        if(req.get("uAccount")!=null) {        	uAccount=req.get("uAccount").toString();        }        if(req.get("oNum")!=null) {        	oNum=req.get("oNum").toString();        }        if(req.get("oPrice")!=null) {        	oPrice=req.get("oPrice").toString();        }        if(req.get("oCheaper")!=null) {        	oCheaper=req.get("oCheaper").toString();        }        if(req.get("uAddress")!=null) {        	uAddress=req.get("uAddress").toString();        }	        if(req.get("oPhone")!=null) {        	oPhone=req.get("oPhone").toString();        }        if(req.get("uReceiver")!=null) {        	uReceiver=req.get("uReceiver").toString();        }        if(StringUtil.isNotEmpty(id)) {        	orders.setoId(id);        }        if(StringUtil.isNotEmpty(uAccount)){        	orders.setuAccount(uAccount);        }        if(StringUtil.isNotEmpty(oNum)) {        	orders.setoNum(Integer.parseInt(oNum));        }        if(StringUtil.isNotEmpty(oPrice)) {        	orders.setoPrice(Float.valueOf(oPrice));        }        if(StringUtil.isNotEmpty(oCheaper)) {        	orders.setoCheaper(Float.valueOf(oCheaper));        }        if(StringUtil.isNotEmpty(uAddress)) {        	orders.setuAddress(uAddress);        }        if(StringUtil.isNotEmpty(oPhone)) {        	orders.setoPhone(oPhone);        }        if(StringUtil.isNotEmpty(uReceiver)) {        	orders.setuReceiver(uReceiver);        }        //订单的添加时间        orders.setoTime(new Date());        
        try {
            //判断非空字段是否为空以及设置创建时间
            if(StringUtils.isEmpty(id)){
                id = StringUtil.seqGenerate().toString();
                orders.setoId(id);            }            //用戶account            if(StringUtil.isEmpty(uAccount)) {            	Users users=(Users) session.getAttribute("users");            	if(users==null) {            		return "userNotLogin";            	}            	uAccount=users.getuAccount();            }            orders.setuAccount(uAccount);                        //查看該用戶下是否有默認收貨地址//            UserAddressExample example=new UserAddressExample();//            Criteria criteria=example.createCriteria();//            criteria.andUAccountEqualTo(uAccount);//            List<UserAddress> userAddressesList=userAdressService.selectByExample(example);//            for(UserAddress ua:userAddressesList) {//            	//1:默認地址   0：非默認//            	if(ua.getuIsdefault()==1) {//            		orders.setuReceiver(ua.getoReceiver());//            		orders.setuAddress(ua.getuAddress());//            		orders.setoPhone(ua.getoPhone());//            	}//            }            
            if (ordersSV.insert(orders) == 1) {            	//添加订单详细信息                List<Object> orderDetailList=(List<Object>) req.get("orderDetails");                for(Object object:orderDetailList) {                	Map<String, String> tempOrderDetailMap=(Map<String, String>) object;                	OrderDetail tempOrderDetail=new OrderDetail();                	if(StringUtil.isNotEmpty(tempOrderDetailMap.get("oDId"))) {                		tempOrderDetail.setoDId(tempOrderDetailMap.get("oDId"));                	}else {                		//生成id主键                		tempOrderDetail.setoDId(StringUtil.seqGenerate().toString());                	}                	if(StringUtil.isNotEmpty(tempOrderDetailMap.get("oId"))) {                		tempOrderDetail.setoId(tempOrderDetailMap.get("oId"));                	}else {                		//获取刚插入数据库的订单Id                		tempOrderDetail.setoId(orders.getoId());                	}                	tempOrderDetail.setbId(tempOrderDetailMap.get("bId"));                	tempOrderDetail.setbName(tempOrderDetailMap.get("bName"));                	if(StringUtil.isNotEmpty(tempOrderDetailMap.get("bNums"))) {                		tempOrderDetail.setbNums(Integer.valueOf(tempOrderDetailMap.get("bNums")));                	}                	if(StringUtil.isNotEmpty(tempOrderDetailMap.get("bPrice"))) {                		tempOrderDetail.setbPrice(Float.valueOf(tempOrderDetailMap.get("bPrice")));                	}                	if(StringUtil.isNotEmpty(tempOrderDetailMap.get("bDiscountprice"))) {                		tempOrderDetail.setbDiscountprice(Float.valueOf(tempOrderDetailMap.get("bDiscountprice")));                	}                	if(StringUtil.isNotEmpty(tempOrderDetailMap.get("bSumprice"))) {                		tempOrderDetail.setbSumprice(Float.valueOf(tempOrderDetailMap.get("bSumprice")));                	}                	if(StringUtil.isNotEmpty(tempOrderDetailMap.get("bSumdiscountprice"))) {                		tempOrderDetail.setbSumdiscountprice(Float.valueOf(tempOrderDetailMap.get("bSumdiscountprice")));                	}                	if(orderDetailService.insert(tempOrderDetail)!=1) {                		return "addOrderDetailError";                	}                }	                                //删除购物车中的相关数据                if (idList.size() != 0 && idList != null) {                    for (int i = 0; i < idList.size(); i++) {                        String id2 = idList.get(i);                        if (cartService.selectByPrimaryKey(id2) != null) {                            if (cartService.deleteByPrimaryKey(id2) == 1) {                                strSuc += (id2 + " ");                            } else {                                strFail += (id2 + " ");                            }                       } else {                           strNotExist += (id2 + " ");                   }                   }                    if (strNotExist.equals("") && strFail.equals("")) {                        return strSuc + "delete success";                    } else {                       return strNotExist + "delete error";                    }                } else {                    return "cartIdsNull";                }                                //return "success";
            }else {
                return "addOrderError";
            }
        } catch (Exception e) {
            return "error";
        }
    }
    @RequestMapping(value="/updateOrders",method=RequestMethod.POST)    @ResponseBody
    public String updateOrders(@RequestBody Map<String, String>req){
        String id = req.get("oId");
        try {        	//缺少主鍵
            if(StringUtils.isEmpty(id)){
                return "oIdNull";
            }
           
            Orders orders = ordersSV.createOrders(req);
            if (ordersSV.updateByPrimaryKeySelective(orders) == 1) {
                return "success";
            }else {
               return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
    @RequestMapping(value="/deleteOrders",method=RequestMethod.POST)    @ResponseBody
    public String deleteOrders(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";              OrderDetailExample example=new OrderDetailExample();        com.bookshop.modle.OrderDetailExample.Criteria criteria=example.createCriteria();        try {
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id = idList.get(i);
                    if (ordersSV.selectByPrimaryKey(id) != null) {
                        if (ordersSV.deleteByPrimaryKey(id) == 1) {
                            strSuc += (id + " ");
                        } else {
                            strFail += (id + " ");
                        }
                    } else {
                       strNotExist += (id + " ");                                       }                    //刪除orderDetail中相应数据                    try {                    	criteria.andOIdEqualTo(id);                        orderDetailService.deleteByExample(example);                    }catch (Exception e) {                    	return "error";                    }                }
                if (strNotExist.equals("") && strFail.equals("")) {
                    return strSuc + "delete success";
                } else {
                    return strFail + strNotExist + "delete error";
                }
            } else {
                return "idsNull";
            }
        } catch (Exception e) {
            return "error";
        }
    }
}