package com.bookshop.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop.dao.RecommendBookMapper;
import com.bookshop.modle.Books;
import com.bookshop.modle.BooksExample;
import com.bookshop.service.BooksService;
import com.bookshop.service.RecommendBookService;
import com.bookshop.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("books")
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@Autowired
	RecommendBookService recommendBookService;
	
	@RequestMapping("/initBooks")
	@ResponseBody
	public Map initBooks(@RequestParam(name="category",required=false)String category,
			@RequestParam(name="saleNum",required=false)String saleNum,
			@RequestParam(name="discount",required=false)String discount,
			@RequestParam(name="newset",required=false)String newset,
			@RequestParam(name="price",required=false)String price,
			@RequestParam(name="lowsetPrice",required=false)Float lowestPrice,
			@RequestParam(name="highestPrice",required=false)Float highestPrice,
			@RequestParam(name="page",required=false)String page,
			@RequestParam(name="limit",required=false)String limit) {
		Map<String, Object> resultMap=new HashMap<>();
		String category1,saleNum1,discount1,newset1,price1;
		List<Map<String, String>> resultList=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		int pageNum =  page == null ? 1 : Integer.parseInt(page);
	    int pageSize =  limit == null ? 10 : Integer.parseInt(limit);
		
		category1=category==null?null:"%"+category+"%";
		saleNum1=saleNum==null?null:saleNum.equals("desc")?"desc":saleNum.equals("asc")?"asc":null;
		discount1=discount==null?null:discount.equals("desc")?"desc":discount.equals("asc")?"asc":null;
		newset1=newset==null?null:newset.equals("desc")?"desc":newset.equals("asc")?"asc":null;
		price1=price==null?null:price.equals("desc")?"desc":price.equals("asc")?"asc":null;
		//最低价和最高价  只能  同时为空   和  同时非空,否则设值
		if(lowestPrice==null&&highestPrice!=null) {
			lowestPrice=Float.MIN_VALUE;
		}
		if(lowestPrice!=null&&highestPrice==null) {
			highestPrice=Float.MAX_VALUE;
		}
		
		
		//分页
		PageHelper.startPage(pageNum, pageSize);
		
		List<Books> booksList= booksService.getBookByConditions(category1, saleNum1, discount1, newset1, price1, lowestPrice, highestPrice);
		//将bookList 以List<Map<String,Stirng>>形式存储
		for(Books books:booksList) {
			Map<String, String> tempMap=new HashMap<>();
			tempMap.put("bId", books.getbId());
			tempMap.put("bName", books.getbName());
			tempMap.put("bPic", books.getbPic());
			tempMap.put("bDescription", books.getbDescription());
			tempMap.put("bPrice", books.getbPrice().toString());
			tempMap.put("bDiscount", books.getbDiscount().toString());
			tempMap.put("bAuthor", books.getbAuthor());
			tempMap.put("bPress", books.getbPress());
			tempMap.put("bPressTime", sdf.format(books.getbPressTime()));
			tempMap.put("bAddTime", sdf.format(books.getbAddTime()));
			tempMap.put("bService", books.getbService());
			tempMap.put("bSaleNum", books.getbSaleNum().toString());
			resultList.add(tempMap);
		}
		
		//分页
		PageInfo<Books> pageInfo=new PageInfo<>(booksList);
		resultMap.put("pageInfo", pageInfo);
		resultMap.put("books", resultList);
		return resultMap;
	}
	
	
	//查询特价图书
	@RequestMapping("/specialOfferBooks")
	@ResponseBody
	public Map specialOfferBooks(
			@RequestParam(name="page",required=false)String page,
			@RequestParam(name="limit",required=false)String limit) {
		Map<String, Object> resultMap=new HashMap<>();
		
		int pageNum =  page == null ? 1 : Integer.parseInt(page);
        int pageSize =  limit == null ? 4 : Integer.parseInt(limit);
		
		PageHelper.startPage(pageNum, pageSize);
		List<Books> books= booksService.getdiscountBook(pageSize);
		
		PageInfo<Books> pageInfo=new PageInfo<>(books);
		resultMap.put("specialOfferBooks", books);
		resultMap.put("pageInfo", pageInfo);
		
		return resultMap;
	}
	
	@RequestMapping(value="/addBooks",method=RequestMethod.POST)
    public ModelAndView addBooks(@RequestParam("bookPic")MultipartFile bookPic,HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView mav=new ModelAndView();
        String id = request.getParameter("bId");
        String category=request.getParameter("bCategory");//书籍种类
        Map<String , String> req=new HashMap<>();
        String newFileName=null;
        
        if(StringUtil.isEmpty(category)) {
        	mav.addObject("bCategoryNull", "图书种类不能为空");
        	return mav;
        }
        //判断非空字段是否为空 以及设置创建时间
        if(StringUtil.isEmpty(id)){
            id = category+StringUtil.seqGenerate().toString();
            req.put("bId", id);
            newFileName=category+id.toString();
        }
        req.put("bName", request.getParameter("bName"));
        req.put("bDescription", request.getParameter("bDescription"));
        req.put("bPrice", request.getParameter("bPrice"));
        req.put("bDiscount", request.getParameter("bDiscount"));
        req.put("bAuthor", request.getParameter("bAuthor"));
        req.put("bPress", request.getParameter("bPress"));
        req.put("bPressTime", request.getParameter("bPressTime"));
        req.put("bAddTime", request.getParameter("bAddTime"));
        req.put("bService", request.getParameter("bService"));
        req.put("bSaleNum", request.getParameter("bSaleNum"));
        
        //上传图片
        if(!bookPic.isEmpty()) {
        	String path=request.getSession().getServletContext().getRealPath("/img/book_images/");
        	System.out.println("path:：："+path);
        	//设置上传文件名
        	String fileName=bookPic.getOriginalFilename();
        	//取得文件后缀
        	//String[] temp=fileName.split(".");--为空
        	String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
        	newFileName=newFileName+"."+suffix;
        	File file=new File(path, newFileName);
        	//如果目标路径存在，存储图片文件
        	if(file.getParentFile().exists()) {
        		bookPic.transferTo(new File(path+File.separator+newFileName));
        	}else {
        		mav.addObject("pathNotExits", "存储图片的路径不存在，请检查");
        		return mav;
        	}
        }else {
        	mav.addObject("bookPicNotExit", "未选择图书图片");
        }
        
        req.put("bPic", newFileName);
        Books books = booksService.createBooks(req);
        if(books.getbAddTime()==null){
            books.setbAddTime(new Date());
        }
        
        if (booksService.insertSelective(books) == 1) {
        	//更新recommend_book表
        	if(recommendBookService.insertBookColumn(id+"_o_num")!=1) {
        		mav.addObject("upRecommendBookError", "更新图书推荐表失败");
        		return mav;
        	}
        	
        	mav.addObject("bookAddSuccess", "书籍添加成功!");
            //重定向到展示图书页面----------------------------未完成
        	
        }else {
        	mav.addObject("bookAddError", "添加失败!");
        }
        
        return mav;
    }
	
	@RequestMapping(value="/booksQry",method=RequestMethod.GET)
	@ResponseBody
    public Map booksQry(
             @RequestParam(name="bId",required=false)String bId,
             @RequestParam(name="bName",required=false)String bName,
             @RequestParam(name="bDescription",required=false)String bDescription,
             @RequestParam(name="bPrice",required=false)String bPrice,
             @RequestParam(name="bDiscount",required=false)String bDiscount,
             @RequestParam(name="bAuthor",required=false)String bAuthor,
             @RequestParam(name="bPress",required=false)String bPress,
             @RequestParam(name="bPressTimeStart",required=false)String bPressTimeStart,
             @RequestParam(name="bPressTimeEnd",required=false)String bPressTimeEnd,
             @RequestParam(name="bAddTimeStart",required=false)String bAddTimeStart,
             @RequestParam(name="bAddTimeEnd",required=false)String bAddTimeEnd,
             @RequestParam(name="bService",required=false)String bService,
             @RequestParam(name="bSaleNum",required=false)String bSaleNum,
             @RequestParam(name="page",required=false)String page,@RequestParam(name="limit",required=false)String limit) throws UnsupportedEncodingException{
        Map<String, Object> resultMap=new HashMap<>();
        List<Map> mapList = new ArrayList<>();
        int pageNum =  page == null ? 1 : Integer.parseInt(page);
        int pageSize =  limit == null ? 10 : Integer.parseInt(limit);
        Map<String, String> booksExmMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        booksExmMap.put("bId", bId);
        booksExmMap.put("bName", bName);
        booksExmMap.put("bDescription", bDescription);
        booksExmMap.put("bPrice", bPrice);
        booksExmMap.put("bDiscount", bDiscount);
        booksExmMap.put("bAuthor", bAuthor);
        booksExmMap.put("bPress", bPress);
        booksExmMap.put("bPressTimeStart", bPressTimeStart);
        booksExmMap.put("bPressTimeEnd", bPressTimeEnd);
        booksExmMap.put("bAddTimeStart", bAddTimeStart);
        booksExmMap.put("bAddTimeEnd", bAddTimeEnd);
        booksExmMap.put("bService", bService);
        booksExmMap.put("bSaleNum", bSaleNum);
        BooksExample example = booksService.createBooksExm(booksExmMap);
        List<Books> booksList = booksService.selectByExample(example,pageNum,pageSize);
        int total = booksService.countByExample(example);
        for (Books books : booksList) {
            Map<String,Object> tMap = new HashMap<>();
            tMap.put("bId", books.getbId());
            tMap.put("bName", books.getbName());
			tMap.put("bPic", books.getbPic());
            tMap.put("bDescription", books.getbDescription());
            if(books.getbPrice()!=null){
                tMap.put("bPrice", books.getbPrice().toString());
            }
            if(books.getbDiscount()!=null){
                tMap.put("bDiscount", books.getbDiscount().toString());
            }
            tMap.put("bAuthor", books.getbAuthor());
            tMap.put("bPress", books.getbPress());
            if(books.getbPressTime()!=null){
                tMap.put("bPressTime", sdf.format(books.getbPressTime()));
            }
            if(books.getbAddTime()!=null){
                tMap.put("bAddTime", sdf.format(books.getbAddTime()));
            }
            tMap.put("bService", books.getbService());
            if(books.getbSaleNum()!=null){
                tMap.put("bSaleNum", books.getbSaleNum().toString());
            }
            mapList.add(tMap);
        }
        
        PageInfo<Books> pageInfo=new PageInfo<Books>(booksList);
        resultMap.put("books", mapList);
        resultMap.put("pageInfo", pageInfo);
        return resultMap;
    }
	
	@RequestMapping(value="/updateBooks",method=RequestMethod.POST)
    public String updateBooks(@RequestParam("bookPic")MultipartFile bookPic,
    		HttpServletRequest request) throws IllegalStateException, IOException{
		Map<String , String> req=new HashMap<>();
        String id = request.getParameter("bId");
        Map<String,Object> resultMap = new HashMap<>();
        String newFileName=null;
        
        if(StringUtil.isEmpty(id)){
            return "bIdNull";
        }
        
        req.put("bId",id);
        req.put("bName", request.getParameter("bName"));
        req.put("bDescription", request.getParameter("bDescription"));
        req.put("bPrice", request.getParameter("bPrice"));
        req.put("bDiscount", request.getParameter("bDiscount"));
        req.put("bAuthor", request.getParameter("bAuthor"));
        req.put("bPress", request.getParameter("bPress"));
        req.put("bPressTime", request.getParameter("bPressTime"));
        req.put("bAddTime", request.getParameter("bAddTime"));
        req.put("bService", request.getParameter("bService"));
        req.put("bSaleNum", request.getParameter("bSaleNum"));
        
        //修改上传图片
        if(!bookPic.isEmpty()) {
        	//左含右不含
            newFileName=id.substring(0, 1)+StringUtil.seqGenerate();
        	
        	String path=request.getSession().getServletContext().getRealPath("/img/book_images/");
        	System.out.println("path:：："+path);
        	//设置上传文件名
        	String fileName=bookPic.getOriginalFilename();
        	//取得文件后缀
        	//String[] temp=fileName.split(".");--为空
        	String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
        	newFileName=newFileName+"."+suffix;
        	File file=new File(path, newFileName);
        	//如果目标路径存在，存储图片文件
        	if(file.getParentFile().exists()) {
        		bookPic.transferTo(new File(path+File.separator+newFileName));
        	}else {
        		//存储图片的路径不存在，请检查
        		return "pathNotExist";
        	}
        	req.put("bPic", newFileName);
        }
        
        try {
            Books books = booksService.createBooks(req);
            if (booksService.updateByPrimaryKeySelective(books) == 1) {
                return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
        	return "error";
        }
    }

    @RequestMapping(value="/deleteBooks",method=RequestMethod.POST)
    public String deleteBooks(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        Map<String, Object> resultMap = new HashMap<>();
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";        
        try {
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id =idList.get(i);
                    if (booksService.selectByPrimaryKey(id) != null) {
                        if (booksService.deleteByPrimaryKey(id) == 1) {
                            strSuc += (id + " ");
                        } else {
                            strFail += (id + " ");
                        }
                   } else {
                       strNotExist += (id + " ");                   }
               }
                if (strNotExist.equals("") && strFail.equals("")) {
                    return strSuc + "删除成功";
                } else {
                    return strFail + strNotExist + "删除失败";
                }
            } else {
                return "idsNull";
            }
        } catch (Exception e) {
            return "error";
        }
    }
	
}
