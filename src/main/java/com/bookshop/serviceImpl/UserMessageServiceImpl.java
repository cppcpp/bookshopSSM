package com.bookshop.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookshop.service.UserMessageService;
import com.bookshop.modle.UserMessage;
import com.bookshop.modle.UserMessageExample;
import com.bookshop.dao.UserMessageMapper;
import com.github.pagehelper.PageHelper;


public class UserMessageServiceImpl implements UserMessageService {
    @Autowired
    UserMessageMapper dao;
    @Override
    public int countByExample(UserMessageExample example){
        return (int)dao.countByExample(example);
    }

    public int deleteByExample(UserMessageExample example){
        return dao.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return (int)dao.deleteByPrimaryKey(id);
    }

    public int insert(UserMessage record)  {
        return dao.insert(record);
    }

    public int insertSelective(UserMessage record)  {
        return dao.insertSelective(record);
    }

    public List<UserMessage> selectByExample(UserMessageExample example)  {
        return dao.selectByExample(example);
    }

    public UserMessage selectByPrimaryKey(String id)  {
        return dao.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") UserMessage record, @Param("example") UserMessageExample example)  {
        return dao.updateByExampleSelective(record, example);
    }

    public int updateByExample(@Param("record") UserMessage record, @Param("example") UserMessageExample example)  {
        return dao.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(UserMessage record)  {
        return dao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserMessage record)  {
        return dao.updateByPrimaryKey(record);
    }

    public UserMessage createUserMessage(Map<String, String>req) {
        String uAccount = req.get("uAccount");
        String uMessage = req.get("uMessage");
        UserMessage userMessage = new UserMessage();
        if (StringUtils.isNotEmpty(uAccount)) {
            userMessage.setuAccount(uAccount);
        }
        if (StringUtils.isNotEmpty(uMessage)) {
            userMessage.setuMessage(uMessage);
        }
        return userMessage;
    }

    public UserMessageExample createUserMessageExm(Map<String, String>req){
        String uAccount = req.get("uAccount");
        String uMessage = req.get("uMessage");
        UserMessageExample example = new UserMessageExample();
        UserMessageExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(uAccount)) {
            criteria.andUAccountEqualTo(uAccount);
        }
        if (StringUtils.isNotEmpty(uMessage)) {
            criteria.andUMessageEqualTo(uMessage);
        }
        return example;
    }

    public List<UserMessage> selectByExample(UserMessageExample example, int pageNum, int pageSize)  {
        PageHelper.startPage(pageNum, pageSize);
        return dao.selectByExample(example);
    }
}