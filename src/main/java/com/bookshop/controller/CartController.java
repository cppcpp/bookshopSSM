package com.bookshop.controller;import static org.mockito.Matchers.intThat;import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import javax.servlet.http.HttpSession;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.ResponseBody;import com.bookshop.modle.Books;import com.bookshop.modle.Cart;
import com.bookshop.modle.CartExample;import com.bookshop.modle.CartExample.Criteria;import com.bookshop.modle.Users;import com.bookshop.service.BooksService;import com.bookshop.service.CartService;import com.bookshop.util.StringUtil;import com.github.pagehelper.PageHelper;import com.github.pagehelper.PageInfo;
@Controller@RequestMapping("/cart")public class CartController {
	@Autowired	CartService cartService;		@Autowired	BooksService bookService;		@Autowired	HttpSession session;	
    @RequestMapping(value="/cartQry",method=RequestMethod.GET)    @ResponseBody
    public Map cartQry(
             @RequestParam(name="cId",required=false)String cId,
             @RequestParam(name="uAccount",required=false)String uAccount,
             @RequestParam(name="bId",required=false)String bId,
             @RequestParam(name="bName",required=false)String bName,
             @RequestParam(name="bNums",required=false)String bNums,
             @RequestParam(name="bPrice",required=false)String bPrice,
             @RequestParam(name="bDiscountprice",required=false)String bDiscountprice,
             @RequestParam(name="bSumprice",required=false)String bSumprice,
             @RequestParam(name="bSumdiscountprice",required=false)String bSumdiscountprice,             @RequestParam(name="page",required=false)String page, 			 @RequestParam(name="limit",required=false)String limit){    	Map<String, Object> resultMap=new HashMap<>();
        List<Map> mapList = new ArrayList<>();
        Map<String, String> cartExmMap = new HashMap<>();
                int pageNum =  page == null ? 1 : Integer.parseInt(page);	    int pageSize =  limit == null ? 10 : Integer.parseInt(limit);	    
        cartExmMap.put("cId", cId);
        cartExmMap.put("uAccount", uAccount);
        cartExmMap.put("bId", bId);
        cartExmMap.put("bName", bName);
        cartExmMap.put("bNums", bNums);
        cartExmMap.put("bPrice", bPrice);
        cartExmMap.put("bDiscountprice", bDiscountprice);
        cartExmMap.put("bSumprice", bSumprice);
        cartExmMap.put("bSumdiscountprice", bSumdiscountprice);
        CartExample example = cartService.createCartExm(cartExmMap);                PageHelper.startPage(pageNum, pageSize);
        List<Cart> cartList = cartService.selectByExample(example);        Books tempBooks;
        for (Cart cart : cartList) {
            Map<String,Object> tMap = new HashMap<>();
            tMap.put("cId", cart.getcId());
            tMap.put("uAccount", cart.getuAccount());
            tMap.put("bId", cart.getbId());
            tMap.put("bName", cart.getbName());            //通过bId找到bPic保存            tempBooks=bookService.selectByPrimaryKey(cart.getbId());            if(tempBooks!=null) {            	tMap.put("bPic", tempBooks.getbPic());            }else {            	//该书籍不存在，返回            	resultMap.put("bookIsNotExist", "该书籍不存在");            }            if(cart.getbNums()!=null){
                tMap.put("bNums", cart.getbNums().toString());
            }
            if(cart.getbPrice()!=null){
                tMap.put("bPrice", cart.getbPrice().toString());
            }
            if(cart.getbDiscountprice()!=null){
                tMap.put("bDiscountprice", cart.getbDiscountprice().toString());
            }
            if(cart.getbSumprice()!=null){
                tMap.put("bSumprice", cart.getbSumprice().toString());
            }
            if(cart.getbSumdiscountprice()!=null){
                tMap.put("bSumdiscountprice", cart.getbSumdiscountprice().toString());
            }
            mapList.add(tMap);        }
                PageInfo<Cart> pageInfo=new PageInfo<>(cartList);        resultMap.put("pageInfo", pageInfo);
        resultMap.put("cartList", mapList);        return resultMap;
    }        //初始化购物车接口    @RequestMapping("/initCart")    @ResponseBody    public Map initCart(@RequestParam(name="page",required=false)String page,    		@RequestParam(name="limit",required=false)String limit) {    	Map<String, Object> resultMap=new HashMap<>();    	List<Map> mapList = new ArrayList<>();    	    	int pageNum =  page == null ? 1 : Integer.parseInt(page);        int pageSize =  limit == null ? 10 : Integer.parseInt(limit);    	    	Users users=(Users) session.getAttribute("users");    	if(users==null) {    		resultMap.put("userNotExitsError", "用户还未登录，请登录");    		return resultMap;    	}    	String uAccount=users.getuAccount();    	CartExample example=new CartExample();    	Criteria criteria= example.createCriteria();    	criteria.andUAccountEqualTo(uAccount);    	PageHelper.startPage(pageNum, pageSize);    	List<Cart> cartList= cartService.selectByExample(example);    			 Books tempBooks;	     for (Cart cart : cartList) {	         Map<String,Object> tMap = new HashMap<>();	         tMap.put("cId", cart.getcId());	         tMap.put("uAccount", cart.getuAccount());	         tMap.put("bId", cart.getbId());	         tMap.put("bName", cart.getbName());	         //通过bId找到bPic保存	         tempBooks=bookService.selectByPrimaryKey(cart.getbId());	         if(tempBooks!=null) {	         	tMap.put("bPic", tempBooks.getbPic());	         }else {	         	//该书籍不存在，返回	         	resultMap.put("bookIsNotExist", "该书籍不存在");	         }	         if(cart.getbNums()!=null){	             tMap.put("bNums", cart.getbNums().toString());	         }	         if(cart.getbPrice()!=null){	             tMap.put("bPrice", cart.getbPrice().toString());	         }	         if(cart.getbDiscountprice()!=null){	             tMap.put("bDiscountprice", cart.getbDiscountprice().toString());	         }	         if(cart.getbSumprice()!=null){	             tMap.put("bSumprice", cart.getbSumprice().toString());	         }	         if(cart.getbSumdiscountprice()!=null){	             tMap.put("bSumdiscountprice", cart.getbSumdiscountprice().toString());	         }	         mapList.add(tMap);	     }	     PageInfo<Cart> pageInfo=new PageInfo<>(cartList);  	     resultMap.put("cartList", mapList);	     resultMap.put("pageInfo", pageInfo);	     return resultMap;    }
    //统计登录用户购物车个数的接口    @RequestMapping("/countOfCart")    @ResponseBody    public String countOfCart() {    	Users users=(Users) session.getAttribute("users");    	if(users==null) {    		return "userNotExitsError";    	}    	String uAccount=users.getuAccount();    	CartExample example=new CartExample();    	Criteria criteria= example.createCriteria();    	criteria.andUAccountEqualTo(uAccount);    	List<Cart> cartList= cartService.selectByExample(example);    	    	return cartList.size()+"";    }        //添加到购物车    //返回：成功：success  失败：error    @RequestMapping(value="/addCart",method=RequestMethod.POST)    @ResponseBody
    public String addCart(@RequestBody Map<String, String>req){
        String id = req.get("cId");        String uAccount=req.get("uAccount");        String bId=req.get("bId");        String bNum=req.get("bNums");
        try {
            //判断非空字段是否为空 以及设置创建时间
            if(StringUtils.isEmpty(id)){
                id = StringUtil.seqGenerate().toString();
                req.put("cId", id.toString());
            }                        //书籍Id--必须            if(bId==null) {            	return "bIdNull";            }                        //用户账户            if(StringUtil.isEmpty(uAccount)) {            	Users users= (Users) session.getAttribute("users");            	if(users==null) {            		return "userNotLogin";            	}            	            	uAccount=users.getuAccount();            	req.put("uAccount", uAccount);            }            
            Cart cart = cartService.createCart(req);                        //同一用户将同一本书再次加入购物车处理            CartExample example=new CartExample();            Criteria criteria= example.createCriteria();            criteria.andUAccountEqualTo(uAccount);            criteria.andBIdEqualTo(bId);                        //此本书数据库中已存在            List<Cart> cartListTemp=cartService.selectByExample(example);            if(cartListTemp.size()==1) {            	Cart cartTemp=cartListTemp.get(0);            	int num=cartTemp.getbNums();            	//float bSumPrice=cartTemp.getbSumprice();            	//float bSumdiscountprice=cartTemp.getbSumdiscountprice();            	float bPrice=cartTemp.getbPrice();            	float bDiscountPrice=cartTemp.getbDiscountprice();            	if(StringUtil.isNotEmpty(bNum)) {            		num+=Integer.parseInt(bNum);            	}            	cartTemp.setbNums(num);            	cartTemp.setbSumdiscountprice(bDiscountPrice*num);            	cartTemp.setbSumprice(bPrice*num);            	            	if(cartService.updateByPrimaryKey(cartTemp)==1) {            		return "success";            	}else {            		return "error";            	}            }                        if(cartListTemp.size()>1) {            	return "error";            }                      if(cartListTemp.size()==0) {            	if (cartService.insertSelective(cart) == 1) {                    return "success";                }else {                    return "error";                }            }
            
        } catch (Exception e) {
            return "error";
        }                return "error";
    }
    //更新购物车    //返回值：lossId：缺少主键   success：更新成功  error：更新失败        @RequestMapping(value="/updateCart",method=RequestMethod.POST)    @ResponseBody
    public String updateCart(@RequestBody Map<String, String>req){
        String id = req.get("cId");
        Map<String,Object> resultMap = new HashMap<>();
        try {        	//缺少主键
            if(StringUtils.isEmpty(id)){
                return "lossId";
            }
           
            Cart cart = cartService.createCart(req);
            if (cartService.updateByPrimaryKeySelective(cart) == 1) {
               return "success";
            }else {
               return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }
    //返回值：ids+删除成功    ids+删除失败  idsNull：未传入id列表  error：系统异常    @RequestMapping(value="/deleteCart",method=RequestMethod.POST)    @ResponseBody
    public String deleteCart(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";                try {
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id = idList.get(i);
                    if (cartService.selectByPrimaryKey(id) != null) {
                        if (cartService.deleteByPrimaryKey(id) == 1) {
                            strSuc += (id + " ");
                        } else {
                            strFail += (id + " ");
                        }
                   } else {
                       strNotExist += (id + " ");                   }
               }
                if (strNotExist.equals("") && strFail.equals("")) {
                    return strSuc + "delete success";
                } else {
                   return strNotExist + "delete error";
                }
            } else {
                return "idsNull";
            }
        } catch (Exception e) {
            return "error";
        }
    }
}