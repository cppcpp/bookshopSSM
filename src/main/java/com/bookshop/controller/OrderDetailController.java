package com.bookshop.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.modle.OrderDetail;
import com.bookshop.modle.OrderDetailExample;
import com.bookshop.service.OrderDetailService;import com.bookshop.util.StringUtil;
import com.github.pagehelper.PageInfo;

@Controller@RequestMapping("/orderDetail")
public class OrderDetailController {

	@Autowired    OrderDetailService orderDetailSV;

	@ResponseBody    @RequestMapping(value="/orderDetailQry",method=RequestMethod.GET)
    public Map orderDetailQry(
             @RequestParam(name="oDId",required=false)String oDId,
             @RequestParam(name="oId",required=false)String oId,
             @RequestParam(name="bId",required=false)String bId,
             @RequestParam(name="bName",required=false)String bName,
             @RequestParam(name="bNums",required=false)String bNums,
             @RequestParam(name="bPrice",required=false)String bPrice,
             @RequestParam(name="bDiscountprice",required=false)String bDiscountprice,
             @RequestParam(name="bSumprice",required=false)String bSumprice,
             @RequestParam(name="bSumdiscountprice",required=false)String bSumdiscountprice,
             @RequestParam(name="page",required=false)String page,@RequestParam(name="limit",required=false)String limit){
		Map<String, Object> resultMap=new HashMap<>();
        List<Map> mapList = new ArrayList<>();
        int pageNum =  page == null ? 1 : Integer.parseInt(page);
        int pageSize =  limit == null ? 10 : Integer.parseInt(limit);
        Map<String, String> orderDetailExmMap = new HashMap<>();
        
        orderDetailExmMap.put("oDId", oDId);
        orderDetailExmMap.put("oId", oId);
        orderDetailExmMap.put("bId", bId);
        orderDetailExmMap.put("bName", bName);
        orderDetailExmMap.put("bNums", bNums);
        orderDetailExmMap.put("bPrice", bPrice);
        orderDetailExmMap.put("bDiscountprice", bDiscountprice);
        orderDetailExmMap.put("bSumprice", bSumprice);
        orderDetailExmMap.put("bSumdiscountprice", bSumdiscountprice);
        OrderDetailExample example = orderDetailSV.createOrderDetailExm(orderDetailExmMap);
        List<OrderDetail> orderDetailList = orderDetailSV.selectByExample(example,pageNum,pageSize);
        int total = orderDetailSV.countByExample(example);
        for (OrderDetail orderDetail : orderDetailList) {
            Map<String,Object> tMap = new HashMap<>();
            tMap.put("oDId", orderDetail.getoDId());
            tMap.put("oId", orderDetail.getoId());
            tMap.put("bId", orderDetail.getbId());
            tMap.put("bName", orderDetail.getbName());
            if(orderDetail.getbNums()!=null){
                tMap.put("bNums", orderDetail.getbNums().toString());
            }
            if(orderDetail.getbPrice()!=null){
                tMap.put("bPrice", orderDetail.getbPrice().toString());
            }
            if(orderDetail.getbDiscountprice()!=null){
                tMap.put("bDiscountprice", orderDetail.getbDiscountprice().toString());
            }
            if(orderDetail.getbSumprice()!=null){
                tMap.put("bSumprice", orderDetail.getbSumprice().toString());
            }
            if(orderDetail.getbSumdiscountprice()!=null){
                tMap.put("bSumdiscountprice", orderDetail.getbSumdiscountprice().toString());
            }
            mapList.add(tMap);
        }
        
        resultMap.put("oderDetailList", orderDetailList);
        PageInfo<OrderDetail> pageInfo=new PageInfo<>(orderDetailList);
        resultMap.put("pageInfo", pageInfo);
        
        return resultMap;
    }
    @RequestMapping(value="/addOrderDetail",method=RequestMethod.POST)    @ResponseBody
    public String addOrderDetail(@RequestBody Map<String, String>req){
        String id = req.get("oDId");       
        try {
            //判断非空字段是否为空 以及设置创建时间
            if(StringUtils.isEmpty(id)){
                id = StringUtil.seqGenerate().toString();
                req.put("oDId", id.toString());
            }            //订单id-必须            if(StringUtil.isEmpty(req.get("oId"))) {            	return "oIdNull";            }            
            OrderDetail orderDetail = orderDetailSV.createOrderDetail(req);
          
            if (orderDetailSV.insertSelective(orderDetail) == 1) {
                return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
    @RequestMapping(value="/updateOrderDetail",method=RequestMethod.POST)    @ResponseBody
    public String updateOrderDetail(@RequestBody Map<String, String>req){
        String id = req.get("oDId");
        try {        	//缺少主鍵
            if(StringUtils.isEmpty(id)){
                return "oDIdNull";
            }
           
            OrderDetail orderDetail = orderDetailSV.createOrderDetail(req);
            if (orderDetailSV.updateByPrimaryKeySelective(orderDetail) == 1) {
                return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
    @RequestMapping(value="/deleteOrderDetail",method=RequestMethod.POST)    @ResponseBody
    public String deleteOrderDetail(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";        try {
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id = idList.get(i);
                    if (orderDetailSV.selectByPrimaryKey(id) != null) {
                        if (orderDetailSV.deleteByPrimaryKey(id) == 1) {
                            strSuc += (id + " ");
                        } else {
                            strFail += (id + " ");
                        }
                   } else {
                       strNotExist += (id + " ");                   }
               }
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