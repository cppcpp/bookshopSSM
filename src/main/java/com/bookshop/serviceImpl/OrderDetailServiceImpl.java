package com.bookshop.serviceImpl;import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookshop.service.OrderDetailService;
import com.bookshop.modle.OrderDetail;
import com.bookshop.modle.OrderDetailExample;
import com.bookshop.dao.OrderDetailMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailMapper dao;
    @Override
    public int countByExample(OrderDetailExample example){
        return (int)dao.countByExample(example);
    }
    @Override
    public int deleteByExample(OrderDetailExample example){
        return dao.deleteByExample(example);
    }
    @Override
    public int deleteByPrimaryKey(String id){
        return (int)dao.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(OrderDetail record)  {
        return dao.insert(record);
    }
    @Override
    public int insertSelective(OrderDetail record)  {
        return dao.insertSelective(record);
    }
    @Override
    public List<OrderDetail> selectByExample(OrderDetailExample example)  {
        return dao.selectByExample(example);
    }
    @Override
    public OrderDetail selectByPrimaryKey(String id)  {
        return dao.selectByPrimaryKey(id);
    }
    @Override
    public int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example)  {
        return dao.updateByExampleSelective(record, example);
    }
    @Override
    public int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example)  {
        return dao.updateByExample(record, example);
    }
    @Override
    public int updateByPrimaryKeySelective(OrderDetail record)  {
        return dao.updateByPrimaryKeySelective(record);
    }
    @Override
    public int updateByPrimaryKey(OrderDetail record)  {
        return dao.updateByPrimaryKey(record);
    }
    @Override
    public OrderDetail createOrderDetail(Map<String, String>req) {
        String oDId = req.get("oDId");
        String oId = req.get("oId");
        String bId = req.get("bId");
        String bName = req.get("bName");
        String bNums = req.get("bNums");
        String bPrice = req.get("bPrice");
        String bDiscountprice = req.get("bDiscountprice");
        String bSumprice = req.get("bSumprice");
        String bSumdiscountprice = req.get("bSumdiscountprice");
        OrderDetail orderDetail = new OrderDetail();
        if (StringUtils.isNotEmpty(oDId)) {
            orderDetail.setoDId(oDId);
        }
        if (StringUtils.isNotEmpty(oId)) {
            orderDetail.setoId(oId);
        }
        if (StringUtils.isNotEmpty(bId)) {
            orderDetail.setbId(bId);
        }
        if (StringUtils.isNotEmpty(bName)) {
            orderDetail.setbName(bName);
        }
        if (StringUtils.isNotEmpty(bNums)) {
            orderDetail.setbNums(Integer.parseInt(bNums));
        }
        if(StringUtils.isNotEmpty(bPrice)) {
        	orderDetail.setbPrice(Float.valueOf(bPrice));
        }
        if(StringUtils.isNotEmpty(bDiscountprice)) {
        	orderDetail.setbDiscountprice(Float.valueOf(bDiscountprice));
        }
        if(StringUtils.isNotEmpty(bSumprice)) {
        	orderDetail.setbSumprice(Float.valueOf(bSumprice));
        }
        if(StringUtils.isNotEmpty(bSumdiscountprice)) {
        	orderDetail.setbSumdiscountprice(Float.valueOf(bSumdiscountprice));
        }
        return orderDetail;
    }
    @Override
    public OrderDetailExample createOrderDetailExm(Map<String, String>req){
        String oDId = req.get("oDId");
        String oId = req.get("oId");
        String bId = req.get("bId");
        String bName = req.get("bName");
        String bNums = req.get("bNums");
        String bPrice = req.get("bPrice");
        String bDiscountprice = req.get("bDiscountprice");
        String bSumprice = req.get("bSumprice");
        String bSumdiscountprice = req.get("bSumdiscountprice");
        OrderDetailExample example = new OrderDetailExample();
        OrderDetailExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(oDId)) {
            criteria.andODIdEqualTo(oDId);
        }
        if (StringUtils.isNotEmpty(oId)) {
            criteria.andOIdEqualTo(oId);
        }
        if (StringUtils.isNotEmpty(bId)) {
            criteria.andBIdEqualTo(bId);
        }
        if (StringUtils.isNotEmpty(bName)) {
            criteria.andBNameEqualTo(bName);
        }
        if (StringUtils.isNotEmpty(bNums)) {
            criteria.andBNumsEqualTo(Integer.parseInt(bNums));
        }
        if(StringUtils.isNotEmpty(bPrice)) {
        	criteria.andBPriceEqualTo(Float.valueOf(bPrice));
        }
        if(StringUtils.isNotEmpty(bDiscountprice)) {
        	criteria.andBDiscountpriceEqualTo(Float.valueOf(bDiscountprice));
        }
        if(StringUtils.isNotEmpty(bSumprice)) {
        	criteria.andBSumpriceEqualTo(Float.valueOf(bSumprice));
        }
        if(StringUtils.isNotEmpty(bSumdiscountprice)) {
        	criteria.andBSumdiscountpriceEqualTo(Float.valueOf(bSumdiscountprice));
        }
        return example;
    }
    @Override
    public List<OrderDetail> selectByExample(OrderDetailExample example, int pageNum, int pageSize)  {
        PageHelper.startPage(pageNum, pageSize);
        return dao.selectByExample(example);
    }
}