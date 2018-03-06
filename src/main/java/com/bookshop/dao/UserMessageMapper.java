package com.bookshop.dao;

import com.bookshop.modle.UserMessage;
import com.bookshop.modle.UserMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMessageMapper {
    long countByExample(UserMessageExample example);

    int deleteByExample(UserMessageExample example);

    int deleteByPrimaryKey(String uAccount);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    List<UserMessage> selectByExample(UserMessageExample example);

    UserMessage selectByPrimaryKey(String uAccount);

    int updateByExampleSelective(@Param("record") UserMessage record, @Param("example") UserMessageExample example);

    int updateByExample(@Param("record") UserMessage record, @Param("example") UserMessageExample example);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}