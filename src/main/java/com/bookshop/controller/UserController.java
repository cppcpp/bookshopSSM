package com.bookshop.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.modle.Users;
import com.bookshop.modle.UsersExample;
import com.bookshop.modle.UsersExample.Criteria;
import com.bookshop.service.UsersService;
import com.bookshop.util.StringUtil;
import com.bookshop.util.ValidateCode;

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
		
		
		Users users=new Users(uAccount, uPassword, uPhone,uRole);
		if(usersService.insert(users)!=1) {
			resultMap.put("registerError", "服务器问题，注册失败");
		}else {
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
			if(!code.equals(correctCode)) {
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
		criteria.andUPasswordEqualTo(password);
		
		int count=usersService.countByExample(example);
		if(count!=1) {
			resultMap.put("loginError", "用户名或密码错误");
			return resultMap;
		}
		
		resultMap.put("loginSuccess","登录成功");
		Users users=new Users(userName,password);
		//登录成功，保存session
		session.setAttribute("user", users);
		return resultMap;
	}
}
