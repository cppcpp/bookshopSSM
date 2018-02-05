package com.bookshop.service;import com.bookshop.modle.Orders;
import com.bookshop.modle.OrdersExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
public interface OrdersService {
    public int countByExample(OrdersExample example);
    public int deleteByExample(OrdersExample example);
    public int deleteByPrimaryKey(String id);
    public int insert(Orders record);
    public int insertSelective(Orders record);
    public List<Orders> selectByExample(OrdersExample example);
    public Orders selectByPrimaryKey(String id);
    public int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);
    public int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);
    public int updateByPrimaryKeySelective(Orders record);
    public int updateByPrimaryKey(Orders record);
    public Orders createOrders(Map<String, String>req);
    public OrdersExample createOrdersExm(Map<String, String>req);
    public List<Orders> selectByExample(OrdersExample example, int pageNum, int pageSize);
}