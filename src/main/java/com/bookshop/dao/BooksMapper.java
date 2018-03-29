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
    
    List<Books> getNewsetBook(@Param("count")int count);
    
    List<Books> getdiscountBook(@Param("count")int count);
    
    List<Books> getdiscountBookWithLimit(@Param("count")int count);
    
    List<Books> getBestSaleBook(@Param("count")int count);
    
    List<Books> getBookByConditions(@Param("category")String category,@Param("saleNum")String saleNum,@Param("discount")String discount,@Param("newest")String newset,@Param("price")String price,@Param("lowestPrice")Float lowestPrice,@Param("highestPrice")Float highestPrice);
    
    int updateBSaleNum(@Param("bSaleNum")int bSaleNum,@Param("bId")String bId);
    
    
}