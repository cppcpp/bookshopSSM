package com.bookshop.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookshop.service.UserMessageService;
import com.bookshop.modle.UserMessage;
import com.bookshop.modle.UserMessageExample;
import com.bookshop.dao.UserMessageMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService {
    @Autowired
    UserMessageMapper dao;
    @Override
    public int countByExample(UserMessageExample example){
        return (int)dao.countByExample(example);
    }
    @Override
    public int deleteByExample(UserMessageExample example){
        return dao.deleteByExample(example);
    }
    @Override
    public int deleteByPrimaryKey(String id){
        return (int)dao.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(UserMessage record)  {
        return dao.insert(record);
    }
    @Override
    public int insertSelective(UserMessage record)  {
        return dao.insertSelective(record);
    }
    @Override
    public List<UserMessage> selectByExample(UserMessageExample example)  {
        return dao.selectByExample(example);
    }
    @Override
    public UserMessage selectByPrimaryKey(String id)  {
        return dao.selectByPrimaryKey(id);
    }
    @Override
    public int updateByExampleSelective(@Param("record") UserMessage record, @Param("example") UserMessageExample example)  {
        return dao.updateByExampleSelective(record, example);
    }
    @Override
    public int updateByExample(@Param("record") UserMessage record, @Param("example") UserMessageExample example)  {
        return dao.updateByExample(record, example);
    }
    @Override
    public int updateByPrimaryKeySelective(UserMessage record)  {
        return dao.updateByPrimaryKeySelective(record);
    }
    @Override
    public int updateByPrimaryKey(UserMessage record)  {
        return dao.updateByPrimaryKey(record);
    }
    @Override
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
    @Override
    public UserMessageExample createUserMessageExm(Map<String, String>req){
        String uAccount = req.get("uAccount");
        String uMessage = req.get("uMessage");
        String addStartTime=req.get("addStartTime");
        String addStopTime=req.get("addStopTime");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        
        UserMessageExample example = new UserMessageExample();
        UserMessageExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(uAccount)) {
            criteria.andUAccountEqualTo(uAccount);
        }
        if (StringUtils.isNotEmpty(uMessage)) {
            criteria.andUMessageEqualTo(uMessage);
        }
        try {
		    if(StringUtils.isNotEmpty(addStartTime)&&StringUtils.isNotEmpty(addStopTime)){
		    	criteria.andUAddTimeBetween(format.parse(addStartTime), format.parse(addStopTime));
		    }
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return example;
    }
    @Override
    public List<UserMessage> selectByExample(UserMessageExample example, int pageNum, int pageSize)  {
        PageHelper.startPage(pageNum, pageSize);
        return dao.selectByExample(example);
    }
}