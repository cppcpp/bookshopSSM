package com.bookshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookshop.modle.Books;
import com.bookshop.service.BooksService;

@Controller
@RequestMapping("books")
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@RequestMapping("/initBooks")
	@ResponseBody
	public Map initBooks(@RequestParam("category")String category,
			@RequestParam("saleNum")String saleNum,
			@RequestParam("discount")String discount,
			@RequestParam("newset")String newset,
			@RequestParam("price")String price,
			@RequestParam("lowsetPrice")Float lowestPrice,
			@RequestParam("highestPrice")Float highestPrice) {
		Map<String, Object> resultMap=new HashMap<>();
		String category1,saleNum1,discount1,newset1,price1;
		
		category1=category==null?null:"%"+category+"%";
		saleNum1=saleNum==null?null:saleNum.equals("desc")?"desc":saleNum.equals("asc")?"asc":null;
		discount1=discount==null?null:discount.equals("desc")?"desc":discount.equals("asc")?"asc":null;
		newset1=newset==null?null:newset.equals("desc")?"desc":newset.equals("asc")?"asc":null;
		price1=price==null?null:price.equals("desc")?"desc":price.equals("asc")?"asc":null;
		//最低价和最高价  只能  同时为空   和  同时非空,否则设值
		if(lowestPrice==null&&highestPrice!=null) {
			lowestPrice=Float.MIN_VALUE;
		}
		if(lowestPrice!=null&&highestPrice==null) {
			highestPrice=Float.MAX_VALUE;
		}
		
		List<Books> booksList= booksService.getBookByConditions(category1, saleNum1, discount1, newset1, price1, lowestPrice, highestPrice);
		resultMap.put("books", booksList);
		return resultMap;
	}
	
}
