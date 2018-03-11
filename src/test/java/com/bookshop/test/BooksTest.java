package com.bookshop.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookshop.modle.Books;
import com.bookshop.service.BooksService;

public class BooksTest extends BaseTest{
	
	@Autowired
	BooksService booksService;
	
	@Test
	public void getBooksByConditionTest() {
		List<Books> booksList=booksService.getBookByConditions(null,null,"desc",null, null, null, null);
		for(Books books:booksList) {
			System.out.println(books.toString());
		}
		System.out.println("-------------"+booksList.size()+"-----------------");
		//System.out.println(booksList);
	}
	
	
	@Test
	public void specialOfferBooks() {
		booksService.getdiscountBook(4);
	}
}
