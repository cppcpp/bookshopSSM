package com.bookshop.controller;import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import javax.servlet.http.HttpSession;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;import com.bookshop.modle.OrderDetail;import com.bookshop.modle.OrderDetailExample;import com.bookshop.modle.Orders;
import com.bookshop.modle.OrdersExample;import com.bookshop.modle.UserAddress;import com.bookshop.modle.UserAddressExample;import com.bookshop.modle.UserAddressExample.Criteria;import com.bookshop.modle.Users;import com.bookshop.service.OrderDetailService;import com.bookshop.service.OrdersService;import com.bookshop.service.UserAddressService;import com.bookshop.util.StringUtil;
import com.github.pagehelper.PageInfo;
@Controller@RequestMapping("/orders")public class OrdersController {
    @Autowired
    OrdersService ordersSV;        @Autowired    OrderDetailService orderDetailService;        @Autowired    HttpSession session;        @Autowired    UserAddressService userAdressService;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        OrderDetailExample orderDetailExample=new OrderDetailExample();        com.bookshop.modle.OrderDetailExample.Criteria criteria=orderDetailExample.createCriteria();        List<OrderDetail> orderDetailsList;        
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
            }            //订单中包含几本书--即订单详情            criteria.andOIdEqualTo(orders.getoId());            orderDetailsList=orderDetailService.selectByExample(orderDetailExample);            tMap.put("orderDetailsList", orderDetailsList);            mapList.add(tMap);
        }        resultMap.put("orderList", mapList);            //分页信息        PageInfo<Orders> pageInfo=new PageInfo<>(ordersList);        resultMap.put("pageInfo", pageInfo);        
       return resultMap;
    }
    @RequestMapping(value="/addOrders",method=RequestMethod.POST)    @ResponseBody
    public String addOrders(@RequestBody Map<String, String>req){
        String id = req.get("oId");        String uAccount=req.get("uAccount");
        try {
            //判断非空字段是否为空 以及设置创建时间
            if(StringUtils.isEmpty(id)){
                id = StringUtil.seqGenerate().toString();
                req.put("oId", id.toString());
            }            //用戶account            if(StringUtil.isEmpty(uAccount)) {            	Users users=(Users) session.getAttribute("users");            	uAccount=users.getuAccount();            }                        //session中還沒有users，需登錄            if(StringUtil.isEmpty(uAccount)) {            	return "notLogin";            }                        //查看該用戶下是否有默認收貨地址            UserAddressExample example=new UserAddressExample();            Criteria criteria=example.createCriteria();            criteria.andUAccountEqualTo(uAccount);            List<UserAddress> userAddressesList=userAdressService.selectByExample(example);            for(UserAddress ua:userAddressesList) {            	//1:默認地址   0：非默認            	if(ua.getuIsdefault()==1) {            		req.put("uReceiver", ua.getoReceiver());            		req.put("uAddress", ua.getuAddress());            		req.put("oPhone", ua.getoPhone());            	}            }            
            Orders orders = ordersSV.createOrders(req);
          
            if (ordersSV.insertSelective(orders) == 1) {
                return "success";
            }else {
                return "error";
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