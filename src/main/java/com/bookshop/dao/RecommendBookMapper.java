package com.bookshop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RecommendBookMapper {
	int insertUAccount(@Param("uAccount")String uAccount);
	
	List<Map<String, Object>> getAllRecommendBooks(); 
}
