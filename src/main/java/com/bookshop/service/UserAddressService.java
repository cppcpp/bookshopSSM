package com.bookshop.service;import com.bookshop.modle.UserAddress;
import com.bookshop.modle.UserAddressExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
public interface UserAddressService {
    public int countByExample(UserAddressExample example);
    public int deleteByExample(UserAddressExample example);
    public int deleteByPrimaryKey(String id);
    public int insert(UserAddress record);
    public int insertSelective(UserAddress record);
    public List<UserAddress> selectByExample(UserAddressExample example);
    public UserAddress selectByPrimaryKey(String id);
    public int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressExample example);
    public int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example);
    public int updateByPrimaryKeySelective(UserAddress record);
    public int updateByPrimaryKey(UserAddress record);
    public UserAddress createUserAddress(Map<String, String>req);
    public UserAddressExample createUserAddressExm(Map<String, String>req);
    public List<UserAddress> selectByExample(UserAddressExample example, int pageNum, int pageSize);
}