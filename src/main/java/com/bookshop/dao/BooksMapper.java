package com.bookshop.dao;

import com.bookshop.modle.Books;
import com.bookshop.modle.BooksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BooksMapper {
    long countByExample(BooksExample example);

    int deleteByExample(BooksExample example);

    int deleteByPrimaryKey(String bId);

    int insert(Books record);

    int insertSelective(Books record);

    List<Books> selectByExample(BooksExample example);

    Books selectByPrimaryKey(String bId);

    int updateByExampleSelective(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByExample(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
}