package com.bookshop.service;import com.bookshop.modle.Cart;
import com.bookshop.modle.CartExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
public interface CartService {
    public int countByExample(CartExample example);
    public int deleteByExample(CartExample example);
    public int deleteByPrimaryKey(String id);
    public int insert(Cart record);
    public int insertSelective(Cart record);
    public List<Cart> selectByExample(CartExample example);
    public Cart selectByPrimaryKey(String id);
    public int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);
    public int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);
    public int updateByPrimaryKeySelective(Cart record);
    public int updateByPrimaryKey(Cart record);
    public Cart createCart(Map<String, String>req);
    public CartExample createCartExm(Map<String, String>req);
}