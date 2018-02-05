package com.bookshop.dao;

import com.bookshop.modle.BookImages;
import com.bookshop.modle.BookImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookImagesMapper {
    long countByExample(BookImagesExample example);

    int deleteByExample(BookImagesExample example);

    int insert(BookImages record);

    int insertSelective(BookImages record);

    List<BookImages> selectByExample(BookImagesExample example);

    int updateByExampleSelective(@Param("record") BookImages record, @Param("example") BookImagesExample example);

    int updateByExample(@Param("record") BookImages record, @Param("example") BookImagesExample example);
}