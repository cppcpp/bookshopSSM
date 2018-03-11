package com.bookshop.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.modle.Users;
import com.bookshop.modle.UsersExample;
import com.bookshop.modle.UsersExample.Criteria;
import com.bookshop.service.RecommendBookService;
import com.bookshop.service.UsersService;
import com.bookshop.util.StringUtil;
import com.bookshop.util.ValidateCode;
import com.github.pagehelper.PageInfo;

@Controller()
@RequestMapping("/user")
public class UserController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	RecommendBookService recommendBookService;
	
	//生成验证码
	@RequestMapping(value="/generateValidateCode",method=RequestMethod.GET)
	@ResponseBody
	public void generateValidateCode() {
		try {
			ValidateCode.generateValidateCode(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/registerAccount",method=RequestMethod.GET)
	@ResponseBody
	public String registerAccount() {
		Map<String,String> resultMap=new HashMap<>();
		String uAccount=request.getParameter("uAccount");
		
		Users users=usersService.selectByPrimaryKey(uAccount);
		if(users==null) {
			return "uAccountOK";
		}else {
			return "uAccountError";
		}
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Map register() {
		Map<String, String> resultMap=new HashMap<>();
		String uAccount=request.getParameter("uAccount");
		String uPassword=request.getParameter("uPassword");
		String uPhone=request.getParameter("uPhone");
		String uRole=request.getParameter("uRole");
		
		if(StringUtil.isEmpty(uAccount)) {
			resultMap.put("uAccountNull", "用户名不能为空");
			return resultMap;
		}
		if(StringUtil.isEmpty(uPassword)) {
			resultMap.put("uPasswordNull", "密码不能为空");
			return resultMap;
		}
		if(StringUtil.isEmpty(uPhone)) {
			resultMap.put("uPhoneNull", "手机号不能为空");
			return resultMap;
		}
		if(StringUtil.isEmpty(uRole)) {
			resultMap.put("roleNull", "角色不能为空");
			return resultMap;
		}
		
		//对密码进行Md5加密
		String md5Password=StringUtil.EncoderByMd5(uPassword);
		
		Users users=new Users(uAccount, md5Password, uPhone,uRole);
		if(usersService.insert(users)!=1) {
			resultMap.put("registerError", "服务器问题，注册失败");
		}else {
			//更新recommend_books表
			if(recommendBookService.insertUAccount(uAccount)!=1) {
				resultMap.put("recommendBookInsertError", "推荐图书表插入异常");
				return resultMap;
			}
			resultMap.put("registerSuccess", "注册成功");
		}
		
		return resultMap;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Map login() {
		Map<String, String> resultMap=new HashMap<>();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String  code=request.getParameter("code");
		//正确的code
		String correctCode=(String) session.getAttribute("imagecheckcode");
		
		if(StringUtil.isEmpty(code)) {
			resultMap.put("codeNull", "验证码不能为空");
			return resultMap;
		}else {
			//验证码忽略大小写
			if(!code.equalsIgnoreCase(correctCode)) {
				resultMap.put("codeRong", "验证码不正确");
				return resultMap;
			}
		}
		
		if(StringUtil.isEmpty(userName)) {
			resultMap.put("userNameNull", "用户名不能为空");
			return resultMap;
		}
		
		if(StringUtil.isEmpty(password)) {
			resultMap.put("passwordNull", "密码不能为空");
			return resultMap;
		}
		
		UsersExample example=new UsersExample();
		Criteria criteria=example.createCriteria();
		criteria.andUAccountEqualTo(userName);
		String md5Password=StringUtil.EncoderByMd5(password);
		criteria.andUPasswordEqualTo(md5Password);
		
		List<Users> usersList=usersService.selectByExample(example);
		if(usersList.size()<1) {
			resultMap.put("loginError", "用户名或密码错误");
			return resultMap;
		}
		Users tempUsers=usersList.get(0);
		//resultMap.put("loginSuccess","登录成功");
		if(tempUsers.getuRole()==null) {
			resultMap.put("userRoleIsNull", "用户权限为空，请检查");
			return resultMap;
		}
		
		if(tempUsers.getuRole().equals("0")) {
			resultMap.put("buyer","买家");
		}
		
		if(tempUsers.getuRole().equals("1")) {
			resultMap.put("seller", "卖家");
		}
		
		Users users=new Users(userName,password);
		//登录成功，保存session
		session.setAttribute("users", users);
		return resultMap;
	}
	
	@RequestMapping(value="/usersQry",method=RequestMethod.GET)
	@ResponseBody
    public Map usersQry(
             @RequestParam(name="uAccount",required=false)String uAccount,
             @RequestParam(name="uName",required=false)String uName,
             @RequestParam(name="uPassword",required=false)String uPassword,
             @RequestParam(name="uPhone",required=false)String uPhone,
             @RequestParam(name="uMail",required=false)String uMail,
             @RequestParam(name="uRole",required=false)String uRole,
             @RequestParam(name="page",required=false)String page,@RequestParam(name="limit",required=false)String limit){
		Map<String, Object> resultMap=new HashMap<>();
        List<Map> mapList = new ArrayList<>();
        int pageNum =  page == null ? 1 : Integer.parseInt(page);
        int pageSize =  limit == null ? 10 : Integer.parseInt(limit);
        Map<String, String> usersExmMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        usersExmMap.put("uAccount", uAccount);
        usersExmMap.put("uName", uName);
        usersExmMap.put("uPassword", uPassword);
        usersExmMap.put("uPhone", uPhone);
        usersExmMap.put("uMail", uMail);
        usersExmMap.put("uRole", uRole);
        UsersExample example = usersService.createUsersExm(usersExmMap);
        List<Users> usersList = usersService.selectByExample(example,pageNum,pageSize);
        int total = usersService.countByExample(example);
        for (Users users : usersList) {
            Map<String,Object> tMap = new HashMap<>();
            tMap.put("uAccount", users.getuAccount());
            tMap.put("uName", users.getuName());
            tMap.put("uPassword", users.getuPassword());
            tMap.put("uPhone", users.getuPhone());
            tMap.put("uMail", users.getuMail());
            tMap.put("uRole", users.getuRole());
            mapList.add(tMap);
        }
        
        resultMap.put("usersList", usersList);
        PageInfo<Users> pageInfo=new PageInfo<>(usersList);
        resultMap.put("pageInfo", pageInfo);
        return resultMap;
    }
	
	@RequestMapping(value="/updateUsers",method=RequestMethod.POST)
	@ResponseBody
    public String updateUsers(@RequestBody Map<String, String>req){
        String id = req.get("uAccount");
        String password=req.get("uPassword");
        if(StringUtil.isNotEmpty(password)) {
        	String md5Password=StringUtil.EncoderByMd5(password);
        	req.put("uPassword", md5Password);
        }
        try {
            if(StringUtils.isEmpty(id)){
                return "uAccountNull";
            }
            Users users = usersService.createUsers(req);
            if (usersService.updateByPrimaryKeySelective(users) == 1) {
                return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
	
	@RequestMapping(value="/deleteUsers",method=RequestMethod.POST)
	@ResponseBody
    public String deleteUsers(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";        
        try {
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id = idList.get(i);
                    if (usersService.selectByPrimaryKey(id) != null) {
                        if (usersService.deleteByPrimaryKey(id) == 1) {
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
	
	@RequestMapping("/logOut")
	@ResponseBody
	public String logOut() {
		Users users=(Users) session.getAttribute("users");
		
		if(users!=null) {
			session.setAttribute("users", null);
			return "logOutSuccess";
		}
		return "error";
	}
	
	@RequestMapping("/loginUAccount")
	@ResponseBody
	public String logingUAccount() {
		Users users=(Users) session.getAttribute("users");
		if(users!=null) {
			return users.getuAccount();
		}
		return "empty";
	}
	
	//获取用户信息
	@RequestMapping("/getUsersInfo")
	@ResponseBody
	public Map getUsersInfo() {
		Map<String, String> resultMap=new HashMap<>();
		Users sessionUsers=(Users) session.getAttribute("users");
		if(sessionUsers==null) {
			resultMap.put("notLogin", "用户还未登录，请登录");
			return resultMap;
		}
		
		Users users=usersService.selectByPrimaryKey(sessionUsers.getuAccount());
		if(users==null) {
			resultMap.put("userNull", "该用户不存在，请检查");
			return resultMap;
		}
		if(users.getuAccount()!=null) {
			resultMap.put("uAccount", users.getuAccount());
		}else {
			resultMap.put("uAccount", "");
		}
		
		if(users.getuMail()!=null) {
			resultMap.put("uMail",users.getuMail());
		}else {
			resultMap.put("uMail","");
		}
		
		if(users.getuName()!=null) {
			resultMap.put("uName", users.getuName());
		}else {
			resultMap.put("uName", "");
		}
		
		if(users.getuPhone()!=null) {
			resultMap.put("uPassword",users.getuPassword());
		}else {
			resultMap.put("uPassword","");
		}
		
		if(users.getuPhone()!=null) {
			resultMap.put("uPhone", users.getuPhone());
		}else {
			resultMap.put("uPhone", "");
		}
		
		
		return resultMap;
	}
}
