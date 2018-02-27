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
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.modle.UserAddress;
import com.bookshop.modle.UserAddressExample;import com.bookshop.modle.Users;import com.bookshop.service.UserAddressService;import com.bookshop.util.StringUtil;import com.github.pagehelper.PageInfo;
@Controller@RequestMapping("/userAdress")
public class UserAddressController {
	@Autowired	UserAddressService userAddressSV;		@Autowired	HttpSession session;
    @RequestMapping(value="/userAddressQry",method=RequestMethod.GET)    @ResponseBody
    public Map userAddressQry(
             @RequestParam(name="uaddrId",required=false)String uaddrId,
             @RequestParam(name="uAccount",required=false)String uAccount,
             @RequestParam(name="uAddress",required=false)String uAddress,
             @RequestParam(name="oPhone",required=false)String oPhone,
             @RequestParam(name="uIsdefault",required=false)String uIsdefault,
             @RequestParam(name="oReceiver",required=false)String oReceiver,
             @RequestParam(name="page",required=false)String page,@RequestParam(name="limit",required=false)String limit){
    	Map<String, Object> resultMap=new HashMap<>();    	List<Map> mapList = new ArrayList<>();
        int pageNum =  page == null ? 1 : Integer.parseInt(page);
        int pageSize =  limit == null ? 10 : Integer.parseInt(limit);
        Map<String, String> userAddressExmMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
        userAddressExmMap.put("uaddrId", uaddrId);
        userAddressExmMap.put("uAccount", uAccount);
        userAddressExmMap.put("uAddress", uAddress);
        userAddressExmMap.put("oPhone", oPhone);
        userAddressExmMap.put("uIsdefault", uIsdefault);
        userAddressExmMap.put("oReceiver", oReceiver);
        UserAddressExample example = userAddressSV.createUserAddressExm(userAddressExmMap);
        List<UserAddress> userAddressList = userAddressSV.selectByExample(example,pageNum,pageSize);
        int total = userAddressSV.countByExample(example);
        for (UserAddress userAddress : userAddressList) {
            Map<String,Object> tMap = new HashMap<>();
            tMap.put("uaddrId", userAddress.getUaddrId());
            tMap.put("uAccount", userAddress.getuAccount());
            tMap.put("uAddress", userAddress.getuAddress());
            tMap.put("oPhone", userAddress.getoPhone());
            if(userAddress.getuIsdefault()!=null){
                tMap.put("uIsdefault", userAddress.getuIsdefault().toString());
            }
            tMap.put("oReceiver", userAddress.getoReceiver());
            mapList.add(tMap);
        }
                resultMap.put("userAdressList",userAddressList);
        PageInfo<UserAddress> pageInfo=new PageInfo<>(userAddressList);        resultMap.put("pageInfo", pageInfo);
        return resultMap;
    }
    @RequestMapping(value="/addUserAddress",method=RequestMethod.POST)    @ResponseBody
    public String addUserAddress(@RequestBody Map<String, String>req){        String id = req.get("uaddrId");        String uAccount=req.get("uAccount");
        try {
            //判断非空字段是否为空 以及设置创建时间
            if(StringUtils.isEmpty(id)){
                id = StringUtil.seqGenerate().toString();
                req.put("uaddrId", id.toString());
            }                        if(StringUtil.isEmpty(uAccount)) {            	Users users=(Users) session.getAttribute("users");            	uAccount=users.getuAccount();            }            if(StringUtil.isEmpty(uAccount)) {            	return "notLogin";            }            
            UserAddress userAddress = userAddressSV.createUserAddress(req);
          
            if (userAddressSV.insertSelective(userAddress) == 1) {
                return "success";
            }else {
               return "error";
            }
        } catch (Exception e) {
        	return "error";
        }
    }
    @RequestMapping(value="/updateUserAddress",method=RequestMethod.POST)    @ResponseBody
    public String updateUserAddress(@RequestBody Map<String, String>req){
        String id = req.get("uaddrId");
        try {
            if(StringUtils.isEmpty(id)){
                return "uaddrIdNull";
            }
            UserAddress userAddress = userAddressSV.createUserAddress(req);
            if (userAddressSV.updateByPrimaryKeySelective(userAddress) == 1) {
                return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
    @RequestMapping(value="/deleteUserAddress",method=RequestMethod.POST)    @ResponseBody
    public String deleteUserAddress(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";                try {
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id = idList.get(i);
                    if (userAddressSV.selectByPrimaryKey(id) != null) {
                        if (userAddressSV.deleteByPrimaryKey(id) == 1) {
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
        	return "error";        }
    }
}