package com.bookshop.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookshop.dao.RecommendBookMapper;
import com.bookshop.modle.Books;
import com.bookshop.service.RecommendBookService;

public class RecommendBooksTest extends BaseTest{
	
	@Autowired
	RecommendBookMapper mapper;
	
	@Autowired
	RecommendBookService service;
	
	@Test
	public void testgetAllRecommendBookMapper() {
		List<Map<String, Object>> lists= mapper.getAllRecommendBooks();
		System.out.println("------------------------------------------");
		for(Map<String, Object> map:lists) {
			System.out.println(map.get("u_account"));
		}
		
		Assert.assertTrue(lists!=null);
	}
	
	@Test
	public void insertTest() {
		int a= mapper.insertUAccount("ztchun12");
		Assert.assertTrue(a==1);
	}
	

	@Test
	public void testGetRecommendBooks() {
		List<Books> list= service.getRecommendBooks("123", 4);
		System.out.println(list);
	}
}
