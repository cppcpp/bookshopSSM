package com.bookshop.controller;import java.text.SimpleDateFormat;import java.util.ArrayList;import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.modle.UserMessage;
import com.bookshop.modle.UserMessageExample;import com.bookshop.modle.Users;import com.bookshop.service.UserMessageService;import com.bookshop.util.StringUtil;import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/userMessage")
public class UserMessageController {
    @Autowired
    UserMessageService userMessageSV;        @Autowired    HttpSession session;
    @RequestMapping(value="/userMessageQry",method=RequestMethod.GET)    @ResponseBody
    public Map userMessageQry(
             @RequestParam(name="uAccount",required=false)String uAccount,
             @RequestParam(name="uMessage",required=false)String uMessage,             @RequestParam(name="addStartTime",required=false)String addStartTime,             @RequestParam(name="addStopTime",required=false)String addStopTime,
             @RequestParam(name="page",required=false)String page,@RequestParam(name="limit",required=false)String limit){
        List<Map> mapList = new ArrayList<>();        Map<String, Object> resultMap=new HashMap<>();
        int pageNum =  page == null ? 1 : Integer.parseInt(page);
        int pageSize =  limit == null ? 10 : Integer.parseInt(limit);
        Map<String, String> userMessageExmMap = new HashMap<>();       // SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                
        try {
            userMessageExmMap.put("uAccount", uAccount);
            userMessageExmMap.put("uMessage", uMessage);//            if(StringUtils.isNotEmpty(addStartTime)&&StringUtils.isNotEmpty(addStopTime)){//            	userMessageExmMap.put("addStartTime",);//            	//            }            userMessageExmMap.put("addStartTime",addStartTime);            userMessageExmMap.put("addStopTime", addStopTime);            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            UserMessageExample example = userMessageSV.createUserMessageExm(userMessageExmMap);
            List<UserMessage> userMessageList = userMessageSV.selectByExample(example,pageNum,pageSize);
            for (UserMessage userMessage : userMessageList) {
                Map<String,Object> tMap = new HashMap<>();
                tMap.put("uAccount", userMessage.getuAccount());
                tMap.put("uMessage", userMessage.getuMessage());                tMap.put("addStartTime", sdf.format(userMessage.getuAddTime()));
                mapList.add(tMap);
            }                        PageInfo<UserMessage> pageInfo=new PageInfo<>(userMessageList);            resultMap.put("userMessageList", mapList);            resultMap.put("pageInfo", pageInfo);        } catch (Exception e) {        	resultMap.put("error", "error");
        }
        return resultMap;
    }
    @RequestMapping(value="/addUserMessage",method=RequestMethod.POST)    @ResponseBody
    public String addUserMessage(@RequestBody Map<String, String>req){
        String uAccount = req.get("uAccount");        if(StringUtil.isEmpty(uAccount)) {        	Users users=(Users) session.getAttribute("users");        	if(users!=null) {        		uAccount=users.getuAccount();        		req.put("uAccount", uAccount);        	}else {        		return "notLogin";        	}        }
        try {
            UserMessage userMessage = userMessageSV.createUserMessage(req);            userMessage.setuAddTime(new Date());            
            if (userMessageSV.insertSelective(userMessage) == 1) {
                return "success";
            }else {
               return "error";
            }
        } catch (Exception e) {
           return "error";
        }
    }
    @RequestMapping(value="/updateUserMessage",method=RequestMethod.POST)    @ResponseBody
    public String updateUserMessage(@RequestBody Map<String, String>req){    	String uAccount=null;    	Users users=(Users) session.getAttribute("users");    	if(users!=null) {    		uAccount=users.getuAccount();    	}else {    		return "notLogin";    	}
        try {
            UserMessage userMessage = userMessageSV.createUserMessage(req);
            if (userMessageSV.updateByPrimaryKeySelective(userMessage) == 1) {
               return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
           return "error";
        }
    }
    @RequestMapping(value="/deleteUserMessage",method=RequestMethod.POST)    @ResponseBody
    public String deleteUserMessage(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";        try {
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id = idList.get(i);
                    if (userMessageSV.selectByPrimaryKey(id) != null) {
                        if (userMessageSV.deleteByPrimaryKey(id) == 1) {
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
                	return strFail+strNotExist + "delete error";
                }
            } else {
            	return "idsNull";
            }
        } catch (Exception e) {
        	return "error";
        }
    }
}