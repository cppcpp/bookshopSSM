package com.bookshop.service;import com.bookshop.modle.Books;
import com.bookshop.modle.BooksExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
public interface BooksService {
    public int countByExample(BooksExample example);
    public int deleteByExample(BooksExample example);
    public int deleteByPrimaryKey(String id);
    public int insert(Books record);
    public int insertSelective(Books record);
    public List<Books> selectByExample(BooksExample example);
    public Books selectByPrimaryKey(String id);
    public int updateByExampleSelective(@Param("record") Books record, @Param("example") BooksExample example);
    public int updateByExample(@Param("record") Books record, @Param("example") BooksExample example);
    public int updateByPrimaryKeySelective(Books record);
    public int updateByPrimaryKey(Books record);
    public Books createBooks(Map<String, String>req);
    public BooksExample createBooksExm(Map<String, String>req);
    public List<Books> selectByExample(BooksExample example, int pageNum, int pageSize);
    
    public List<Books> getNewsetBook(int count);
    
    public List<Books> getdiscountBook(int count);
    
    public List<Books> getdiscountBookWithLimit(int count);
    
    public List<Books> getBestSaleBook(int count);
    
    public List<Books> getBookByConditions(String category,String saleNum,String discount,String newset,String price,Float lowestPrice,Float highestPrice);

    public int updateBSaleNum(int bSaleNum,String bId);}