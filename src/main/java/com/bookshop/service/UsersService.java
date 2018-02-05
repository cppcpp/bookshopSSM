package com.bookshop.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bookshop.modle.Users;
import com.bookshop.modle.UsersExample;

public interface UsersService {
    public int countByExample(UsersExample example);
    public int deleteByExample(UsersExample example);
    public int deleteByPrimaryKey(String id);
    public int insert(Users record);
    public int insertSelective(Users record);
    public List<Users> selectByExample(UsersExample example);
    public Users selectByPrimaryKey(String id);
    public int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);
    public int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);
    public int updateByPrimaryKeySelective(Users record);
    public int updateByPrimaryKey(Users record);
    public Users createUsers(Map<String, String>req);
    public UsersExample createUsersExm(Map<String, String>req);
    public List<Users> selectByExample(UsersExample example, int pageNum, int pageSize);
}