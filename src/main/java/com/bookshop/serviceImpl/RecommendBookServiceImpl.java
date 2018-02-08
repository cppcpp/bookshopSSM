package com.bookshop.serviceImpl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.dao.RecommendBookMapper;
import com.bookshop.modle.Books;
import com.bookshop.service.BooksService;
import com.bookshop.service.RecommendBookService;
import com.bookshop.util.GeneralException;

@Service("recommendBookService")
public class RecommendBookServiceImpl implements RecommendBookService{
	
	@Autowired
	RecommendBookMapper mapper;
	
	@Autowired
	BooksService bookService;
	
	@Override
	public int insertUAccount(String uAccount) {
		// TODO Auto-generated method stub
		return mapper.insertUAccount(uAccount);
	}

	@Override
	public List<Books> getRecommendBooks(String uAccount, int count) {
		String[] othUAccount ;//除了该用户的其他账户
		Map<String, Object> uAccountBooksInfo=null;//该用户的买书信息
		List<Map<String, Object>> othUAccountBooksInfo=new ArrayList<>();//其他用户的买书信息
		Map<String, Double> angles = new TreeMap<String, Double>();// 放指定用户与其他用户空间夹角
		Map<String, Object> tempMap;
		int j=0;
		
		//获得所有用户和图书的关联信息
		List<Map<String, Object>> resultLists=mapper.getAllRecommendBooks();
		othUAccount=new String[resultLists.size()-1];//初始化数组
		for(int i=0;i<resultLists.size();i++) {
			tempMap=resultLists.get(i);
			if(tempMap.get("u_account")==null) {
				throw new GeneralException("数据库中u_account为空，请检查");
			}
			
			if(tempMap.get("u_account").toString().equals(uAccount)) {
				tempMap.remove("u_account");
				uAccountBooksInfo=tempMap;
			}else {
				//保证其他用户  数组索引  和   链表中的索引对应
				othUAccount[j]=tempMap.get("u_account").toString();
				tempMap.remove("u_account");
				othUAccountBooksInfo.add(j, tempMap);
				j+=1;
			}
			
		}
//		System.out.println("----------------------------------");
//		System.out.println(uAccountBooksInfo);
//		System.out.println(othUAccount.toString());
//		System.out.println(othUAccountBooksInfo);
		
		//求该用户和其他所有用户之间的夹角
		String tempUAccount;Map<String, Object> tempUAccountBooksInfo;Double tempAngle;
		for(int i=0;i<othUAccount.length;i++) {
			tempUAccount=othUAccount[i];
			tempUAccountBooksInfo=othUAccountBooksInfo.get(i);
			
			tempAngle=getAngle(uAccountBooksInfo, tempUAccountBooksInfo);
			angles.put(tempUAccount, tempAngle);
		}
		
		//将angles中的角按照升序排列--角越小，两用户相似度越高
		List<Entry<String, Double>> sortList = new ArrayList<Entry<String, Double>>(angles.entrySet());
		Collections.sort(sortList, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Entry<String, Double> en1,
					Entry<String, Double> en2) {
				return en1.getValue().compareTo(en2.getValue());
			}
		});
			
			
		int bookNum=0;
		List<String> resultBookId=new ArrayList<>();//推荐的书籍Id
		String tempRecommendUser;int tempIndex;Map<String, Object> tempRecommendUAccountBooksInfo;
		
		//按照相似度用户由高到低排序，依次查找推荐的书籍
		for(Entry<String, Double> recommendUsers:sortList) {
			tempRecommendUser=recommendUsers.getKey();
			tempIndex=getIndex(tempRecommendUser, othUAccount);
			tempRecommendUAccountBooksInfo=othUAccountBooksInfo.get(tempIndex);
			
			//得到推荐书籍
			getResultBookId(tempRecommendUAccountBooksInfo, uAccountBooksInfo, bookNum, count, resultBookId);
			
			//书籍数量达到要求
			if(bookNum>=count) {
				break;
			}
		}
		
		List<Books> resultBooks=new ArrayList<>();
		Books tempBook;
		//根据bookId得到图书信息
		for(String bId:resultBookId) {
			tempBook=bookService.selectByPrimaryKey(bId);
			resultBooks.add(tempBook);
		}
		
		return resultBooks;
	}
	
	
	/*
	 * 入参：
	 * uAccountBooksInfo：该用户与每本图书的购买关系
	 * othUAccountBooksInfo：其他用户与每本图书的购买关系
	 * 
	 * 向量a•向量b=|a|• |b|consΘ 
	 * 
	 * 
	 * */
	public double getAngle(Map<String, Object> uAccountBooksInfo,Map<String, Object> othUAccountBooksInfo) {
		int powA=0,powB=0;//两个向量的平方和
		int sumPointMul=0;//两个向量的点乘
		int a,b;
		double angleCos;//角的余弦值
		double angle;
		
		for(String key:uAccountBooksInfo.keySet()) {
			a=Integer.parseInt(uAccountBooksInfo.get(key).toString());
			b=Integer.parseInt(othUAccountBooksInfo.get(key).toString());
			
			sumPointMul+=a*b;
			powA+=Math.pow(a, 2);
			powB+=Math.pow(b, 2);
			
		}
		
		
		if (powA == 0 || powB == 0) {
			return -1;
		}
		// 算出余弦值
		angleCos = sumPointMul / (Math.sqrt(powA) * Math.sqrt(powB));
		// 利用反三角函数算出夹角
		angle = Math.acos(angleCos);
		return angle;
	}
	
	//得到字符串在字符数组中的下标
	public Integer getIndex(String str,String[] strArray) {
		for(int i=0;i<strArray.length;i++) {
			if(strArray[i]==null) {
				throw new GeneralException("请检查数据库，出现u_account为空的情况");
			}
				
			if(str.equals(strArray[i])) {
				return i;
			}
		}
		
		return null;
	}
	
	/*
	 * 得到期望的书籍Id
	 * 入参：
	 * recommendUAccountBooksInfo：期望用户的图书信息
	 * uAccountBooksInfo：该用户的图书信息
	 * bookNum：已经得到的推荐的图书数量
	 * expectedCount：期望得到的图书数量
	 * resultBookId：图书Id结果
	 * 
	 * 
	 * */
	public void getResultBookId(Map<String, Object> recommendUAccountBooksInfo,Map<String,Object> uAccountBooksInfo,int bookNum,int expectedCount,List<String> resultBookId){
		//将期望用户的图书信息降序排列
		List<Entry<String, Object>> sortList=new ArrayList<>(recommendUAccountBooksInfo.entrySet());
		Collections.sort(sortList, new Comparator<Entry<String, Object>>() {

			@Override
			public int compare(Entry<String, Object> o1, Entry<String, Object> o2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(o2.getValue().toString())-Integer.parseInt(o1.getValue().toString());
			}
		});
		
		if(bookNum>=expectedCount) {
			return ;
		}
		
		String[] tempBook;String tempBookId;
		for(Entry<String,Object> entry:sortList) {
			
			//按照降序排序的推荐书籍购买量为0，直接退出
			if(Integer.parseInt(entry.getValue().toString())==0) {
				return;
			}
			
			//bookNum已经达到想要数量，退出
			if(bookNum>=expectedCount) {
				return;
			}
			
			//该用户包含此书且 从未购买过
			if(uAccountBooksInfo.containsKey(entry.getKey())&&Integer.parseInt(uAccountBooksInfo.get(entry.getKey()).toString())==0) {
				//得到图书id
				tempBook=entry.getKey().toString().split("_");
				tempBookId=tempBook[0];
				
				bookNum++;
				resultBookId.add(tempBookId);
			}
		}
		
	}

}
