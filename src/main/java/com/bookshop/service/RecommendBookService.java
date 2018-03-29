package com.bookshop.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bookshop.modle.Books;

public interface RecommendBookService {
	int insertUAccount(String uAccount);
	List<Books> getRecommendBooks(String uAccount,int count);
	//插入列
	int insertBookColumn(String column);
	
	//更新书本数量信息
	int updateBookNum(String column,int num,String uAccount);
}
