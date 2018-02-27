package com.bookshop.serviceImpl;import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookshop.service.CartService;
import com.bookshop.util.StringUtil;
import com.bookshop.modle.Cart;
import com.bookshop.modle.CartExample;
import com.bookshop.dao.CartMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper dao;
    @Override
    public int countByExample(CartExample example){
        return (int)dao.countByExample(example);
    }
    @Override
    public int deleteByExample(CartExample example){
        return dao.deleteByExample(example);
    }
    @Override
    public int deleteByPrimaryKey(String id){
        return (int)dao.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(Cart record)  {
        return dao.insert(record);
    }
    @Override
    public int insertSelective(Cart record)  {
        return dao.insertSelective(record);
    }
    @Override
    public List<Cart> selectByExample(CartExample example)  {
        return dao.selectByExample(example);
    }
    @Override
    public Cart selectByPrimaryKey(String id)  {
        return dao.selectByPrimaryKey(id);
    }
    @Override
    public int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example)  {
        return dao.updateByExampleSelective(record, example);
    }
    @Override
    public int updateByExample(@Param("record") Cart record, @Param("example") CartExample example)  {
        return dao.updateByExample(record, example);
    }
    @Override
    public int updateByPrimaryKeySelective(Cart record)  {
        return dao.updateByPrimaryKeySelective(record);
    }
    @Override
    public int updateByPrimaryKey(Cart record)  {
        return dao.updateByPrimaryKey(record);
    }
    @Override
    public Cart createCart(Map<String, String>req) {
        String cId = req.get("cId");
        String uAccount = req.get("uAccount");
        String bId = req.get("bId");
        String bName = req.get("bName");
        String bNums = req.get("bNums");
        String bPrice = req.get("bPrice");
        String bDiscountprice = req.get("bDiscountprice");
        String bSumprice = req.get("bSumprice");
        String bSumdiscountprice = req.get("bSumdiscountprice");
        Cart cart = new Cart();
        if (StringUtils.isNotEmpty(cId)) {
            cart.setcId(cId);
        }
        if (StringUtils.isNotEmpty(uAccount)) {
            cart.setuAccount(uAccount);
        }
        if (StringUtils.isNotEmpty(bId)) {
            cart.setbId(bId);
        }
        if (StringUtils.isNotEmpty(bName)) {
            cart.setbName(bName);
        }
        if (StringUtils.isNotEmpty(bNums)) {
            cart.setbNums(Integer.parseInt(bNums));
        }
        if(StringUtils.isNotEmpty(bPrice)) {
        	cart.setbPrice(Float.valueOf(bPrice));
        }
        if(StringUtils.isNotEmpty(bDiscountprice)) {
        	cart.setbDiscountprice(Float.valueOf(bDiscountprice));
        }
        if(StringUtils.isNotEmpty(bSumprice)) {
        	cart.setbSumprice(Float.valueOf(bSumprice));
        }
        if(StringUtils.isNotEmpty(bSumdiscountprice)) {
        	cart.setbSumdiscountprice(Float.valueOf(bSumdiscountprice));
        }
        return cart;
    }
    @Override
    public CartExample createCartExm(Map<String, String>req){
        String cId = req.get("cId");
        String uAccount = req.get("uAccount");
        String bId = req.get("bId");
        String bName = req.get("bName");
        String bNums = req.get("bNums");
        String bPrice = req.get("bPrice");
        String bDiscountprice = req.get("bDiscountprice");
        String bSumprice = req.get("bSumprice");
        String bSumdiscountprice = req.get("bSumdiscountprice");
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isNotEmpty(cId)) {
            criteria.andCIdEqualTo(cId);
        }
        if (StringUtils.isNotEmpty(uAccount)) {
            criteria.andUAccountEqualTo(uAccount);
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
        return example;
    }
}