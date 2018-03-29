package com.bookshop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RecommendBookMapper {
	int insertUAccount(@Param("uAccount")String uAccount);
	
	//增加书籍，增加一列
	int insertBookColumn(@Param("column")String column);
	
	List<Map<String, Object>> getAllRecommendBooks(); 
	
	int updateBookNum(@Param("column")String column,@Param("num")int num,@Param("uAccount")String uAccount); 
}
