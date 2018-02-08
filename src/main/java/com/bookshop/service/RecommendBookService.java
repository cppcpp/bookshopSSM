package com.bookshop.service;

import java.util.List;

import com.bookshop.modle.Books;

public interface RecommendBookService {
	int insertUAccount(String uAccount);
	List<Books> getRecommendBooks(String uAccount,int count);
}
