package com.bookshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.modle.Books;
import com.bookshop.modle.Users;
import com.bookshop.service.BooksService;
import com.bookshop.service.RecommendBookService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	BooksService booksService;
	
	@Autowired
	RecommendBookService recommendBookService;
	
	@Autowired
	HttpSession session;
	
	//初始化首页图书信息--三种：最新图书3本，特价图书4本，为你推荐8本
	@RequestMapping("/initIndexPage")
	@ResponseBody
	public Map initIndex() {
		Users users=(Users) session.getAttribute("users");
		String uAccount=null;
		Map<String,Object> resultMap=new HashMap<>();
		
		if(users!=null) {
			uAccount=users.getuAccount();
		}
		
		List<Books> newsetThreeBooks=booksService.getNewsetBook(3);
		List<Books> discountFourBooks=booksService.getdiscountBook(8);
		List<Books> recommendFourBooks=recommendBookService.getRecommendBooks(uAccount, 4);
		List<Books> bestSaleFourBooks=booksService.getBestSaleBook(8);
		
		
		resultMap.put("newsetThreeBooks",newsetThreeBooks );
		resultMap.put("discountFourBooks", discountFourBooks);
		resultMap.put("recommendFourBooks", recommendFourBooks);
		resultMap.put("bestSaleFourBooks",bestSaleFourBooks );
		
		return resultMap;
	}
}
