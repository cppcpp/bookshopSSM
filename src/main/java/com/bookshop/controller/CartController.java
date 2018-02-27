package com.bookshop.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookshop.modle.CartExample;
@Controller

    @RequestMapping(value="/cartQry",method=RequestMethod.GET)
    public Map cartQry(
             @RequestParam(name="cId",required=false)String cId,
             @RequestParam(name="uAccount",required=false)String uAccount,
             @RequestParam(name="bId",required=false)String bId,
             @RequestParam(name="bName",required=false)String bName,
             @RequestParam(name="bNums",required=false)String bNums,
             @RequestParam(name="bPrice",required=false)String bPrice,
             @RequestParam(name="bDiscountprice",required=false)String bDiscountprice,
             @RequestParam(name="bSumprice",required=false)String bSumprice,
             @RequestParam(name="bSumdiscountprice",required=false)String bSumdiscountprice){
        List<Map> mapList = new ArrayList<>();
        Map<String, String> cartExmMap = new HashMap<>();
        
        cartExmMap.put("cId", cId);
        cartExmMap.put("uAccount", uAccount);
        cartExmMap.put("bId", bId);
        cartExmMap.put("bName", bName);
        cartExmMap.put("bNums", bNums);
        cartExmMap.put("bPrice", bPrice);
        cartExmMap.put("bDiscountprice", bDiscountprice);
        cartExmMap.put("bSumprice", bSumprice);
        cartExmMap.put("bSumdiscountprice", bSumdiscountprice);
        CartExample example = cartService.createCartExm(cartExmMap);
        List<Cart> cartList = cartService.selectByExample(example);
        for (Cart cart : cartList) {
            Map<String,Object> tMap = new HashMap<>();
            tMap.put("cId", cart.getcId());
            tMap.put("uAccount", cart.getuAccount());
            tMap.put("bId", cart.getbId());
            tMap.put("bName", cart.getbName());
            if(cart.getbNums()!=null){
                tMap.put("bNums", cart.getbNums().toString());
            }
            if(cart.getbPrice()!=null){
                tMap.put("bPrice", cart.getbPrice().toString());
            }
            if(cart.getbDiscountprice()!=null){
                tMap.put("bDiscountprice", cart.getbDiscountprice().toString());
            }
            if(cart.getbSumprice()!=null){
                tMap.put("bSumprice", cart.getbSumprice().toString());
            }
            if(cart.getbSumdiscountprice()!=null){
                tMap.put("bSumdiscountprice", cart.getbSumdiscountprice().toString());
            }
            mapList.add(tMap);
        }
           
        resultMap.put("cartList", mapList);
    }

    public String addCart(@RequestBody Map<String, String>req){
        String id = req.get("cId");
        try {
            //判断非空字段是否为空 以及设置创建时间
            if(StringUtils.isEmpty(id)){
                id = StringUtil.seqGenerate().toString();
                req.put("cId", id.toString());
            }
            Cart cart = cartService.createCart(req);
          
            if (cartService.insertSelective(cart) == 1) {
                return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    public String updateCart(@RequestBody Map<String, String>req){
        String id = req.get("cId");
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(StringUtils.isEmpty(id)){
                return "lossId";
            }
           
            Cart cart = cartService.createCart(req);
            if (cartService.updateByPrimaryKeySelective(cart) == 1) {
               return "success";
            }else {
               return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    public String deleteCart(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        Map<String, Object> resultMap = new HashMap<>();
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";        
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id = idList.get(i);
                    if (cartService.selectByPrimaryKey(id) != null) {
                        if (cartService.deleteByPrimaryKey(id) == 1) {
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
                   return strNotExist + "delete error";
                }
            } else {
                return "idsNull";
            }
        } catch (Exception e) {
            return "error";
        }
    }
}