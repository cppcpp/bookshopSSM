package com.bookshop.service;import com.bookshop.modle.OrderDetail;
import com.bookshop.modle.OrderDetailExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
public interface OrderDetailService {
    public int countByExample(OrderDetailExample example);
    public int deleteByExample(OrderDetailExample example);
    public int deleteByPrimaryKey(String id);
    public int insert(OrderDetail record);
    public int insertSelective(OrderDetail record);
    public List<OrderDetail> selectByExample(OrderDetailExample example);
    public OrderDetail selectByPrimaryKey(String id);
    public int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);
    public int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);
    public int updateByPrimaryKeySelective(OrderDetail record);
    public int updateByPrimaryKey(OrderDetail record);
    public OrderDetail createOrderDetail(Map<String, String>req);
    public OrderDetailExample createOrderDetailExm(Map<String, String>req);
    public List<OrderDetail> selectByExample(OrderDetailExample example, int pageNum, int pageSize);
}