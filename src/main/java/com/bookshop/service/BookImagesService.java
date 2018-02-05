package com.bookshop.service;import com.bookshop.modle.BookImages;
import com.bookshop.modle.BookImagesExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
public interface BookImagesService {
    public int countByExample(BookImagesExample example);
    public int deleteByExample(BookImagesExample example);
    public int insert(BookImages record);
    public int insertSelective(BookImages record);
    public List<BookImages> selectByExample(BookImagesExample example);
    public int updateByExampleSelective(@Param("record") BookImages record, @Param("example") BookImagesExample example);
    public int updateByExample(@Param("record") BookImages record, @Param("example") BookImagesExample example);
    public BookImages createBookImages(Map<String, String>req);
    public BookImagesExample createBookImagesExm(Map<String, String>req);
    public List<BookImages> selectByExample(BookImagesExample example, int pageNum, int pageSize);
}