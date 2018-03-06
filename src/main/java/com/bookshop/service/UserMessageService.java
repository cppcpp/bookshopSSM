package com.bookshop.service;

import com.bookshop.modle.UserMessage;
import com.bookshop.modle.UserMessageExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
public interface UserMessageService {
    public int countByExample(UserMessageExample example);
    public int deleteByExample(UserMessageExample example);
    public int deleteByPrimaryKey(String id);
    public int insert(UserMessage record);
    public int insertSelective(UserMessage record);
    public List<UserMessage> selectByExample(UserMessageExample example);
    public UserMessage selectByPrimaryKey(String id);
    public int updateByExampleSelective(@Param("record") UserMessage record, @Param("example") UserMessageExample example);
    public int updateByExample(@Param("record") UserMessage record, @Param("example") UserMessageExample example);
    public int updateByPrimaryKeySelective(UserMessage record);
    public int updateByPrimaryKey(UserMessage record);
    public UserMessage createUserMessage(Map<String, String>req);
    public UserMessageExample createUserMessageExm(Map<String, String>req);
    public List<UserMessage> selectByExample(UserMessageExample example, int pageNum, int pageSize);
}