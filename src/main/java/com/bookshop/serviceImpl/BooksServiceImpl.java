package com.bookshop.serviceImpl;import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookshop.service.BooksService;
import com.bookshop.util.StringUtil;
import com.bookshop.modle.Books;
import com.bookshop.modle.BooksExample;
import com.bookshop.dao.BooksMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
@Service("booksService")
public class BooksServiceImpl implements BooksService {
    @Autowired
    BooksMapper dao;
    
    @Override
    public int countByExample(BooksExample example){
        return (int)dao.countByExample(example);
    }
    @Override
    public int deleteByExample(BooksExample example){
        return dao.deleteByExample(example);
    }
    @Override
    public int deleteByPrimaryKey(String id){
        return (int)dao.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(Books record)  {
        return dao.insert(record);
    }
    @Override
    public int insertSelective(Books record)  {
        return dao.insertSelective(record);
    }
    @Override
    public List<Books> selectByExample(BooksExample example)  {
        return dao.selectByExample(example);
    }
    @Override
    public Books selectByPrimaryKey(String id)  {
        return dao.selectByPrimaryKey(id);
    }
    @Override
    public int updateByExampleSelective(@Param("record") Books record, @Param("example") BooksExample example)  {
        return dao.updateByExampleSelective(record, example);
    }
    @Override
    public int updateByExample(@Param("record") Books record, @Param("example") BooksExample example)  {
        return dao.updateByExample(record, example);
    }
    @Override
    public int updateByPrimaryKeySelective(Books record)  {
        return dao.updateByPrimaryKeySelective(record);
    }
    @Override
    public int updateByPrimaryKey(Books record)  {
        return dao.updateByPrimaryKey(record);
    }
    @Override
    public Books createBooks(Map<String, String>req) {
        String bId = req.get("bId");
        String bPic=req.get("bPic");
        String bName = req.get("bName");
        String bDescription = req.get("bDescription");
        String bPrice = req.get("bPrice");
        String bDiscount = req.get("bDiscount");
        String bAuthor = req.get("bAuthor");
        String bPress = req.get("bPress");
        String bPressTime = req.get("bPressTime");
        String bAddTime = req.get("bAddTime");
        String bService = req.get("bService");
        String bSaleNum = req.get("bSaleNum");
        Books books = new Books();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotEmpty(bId)) {
            books.setbId(bId);
        }
        if(StringUtil.isNotEmpty(bPic)) {
        	books.setbPic(bPic);
        }
        if (StringUtils.isNotEmpty(bName)) {
            books.setbName(bName);
        }
        if(StringUtils.isNotEmpty(bPrice)) {
        	books.setbPrice(Float.valueOf(bPrice));
        }
        if (StringUtils.isNotEmpty(bDescription)) {
            books.setbDescription(bDescription);
        }
        if (StringUtils.isNotEmpty(bDiscount)) {
            books.setbDiscount(Integer.parseInt(bDiscount));
        }
        if (StringUtils.isNotEmpty(bAuthor)) {
            books.setbAuthor(bAuthor);
        }
        if (StringUtils.isNotEmpty(bPress)) {
            books.setbPress(bPress);
        }
        try{
            if (StringUtils.isNotEmpty(bPressTime)) {
                books.setbPressTime(sdf.parse(bPressTime)); 
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        try{
            if (StringUtils.isNotEmpty(bAddTime)) {
                books.setbAddTime(sdf.parse(bAddTime)); 
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotEmpty(bService)) {
            books.setbService(bService);
        }
        if (StringUtils.isNotEmpty(bSaleNum)) {
            books.setbSaleNum(Integer.parseInt(bSaleNum));
        }
        return books;
    }
    @Override
    public BooksExample createBooksExm(Map<String, String>req){
        String bId = req.get("bId");
        String bPic=req.get("bPic");
        String bName = req.get("bName");
        String bDescription = req.get("bDescription");
        String bPrice = req.get("bPrice");
        String bDiscount = req.get("bDiscount");
        String bAuthor = req.get("bAuthor");
        String bPress = req.get("bPress");
        String bPressTimeStart = req.get("bPressTimeStart");
        String bPressTimeEnd = req.get("bPressTimeEnd");
        String bAddTimeStart = req.get("bAddTimeStart");
        String bAddTimeEnd = req.get("bAddTimeEnd");
        String bService = req.get("bService");
        String bSaleNum = req.get("bSaleNum");
        BooksExample example = new BooksExample();
        BooksExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (StringUtils.isNotEmpty(bId)) {
            criteria.andBIdEqualTo(bId);
        }
        if(StringUtils.isNotEmpty(bPic)) {
        	criteria.andBPicLike("%"+bPic+"%");
        }
        if (StringUtils.isNotEmpty(bName)) {
            criteria.andBNameLike("%"+bName+"%");
        }
        if (StringUtils.isNotEmpty(bDescription)) {
            criteria.andBDescriptionLike("%"+bDescription+"%");
        }
        if(StringUtils.isNotEmpty(bPrice)) {
        	criteria.andBPriceEqualTo(Float.valueOf(bPrice));
        }
        if (StringUtils.isNotEmpty(bDiscount)) {
            criteria.andBDiscountEqualTo(Integer.parseInt(bDiscount));
        }
        if (StringUtils.isNotEmpty(bAuthor)) {
            criteria.andBAuthorLike("%"+bAuthor+"%");
        }
        if (StringUtils.isNotEmpty(bPress)) {
            criteria.andBPressLike("%"+bPress+"%");
        }
        try{
            if (StringUtils.isNotEmpty(bPressTimeStart) && StringUtils.isNotEmpty(bPressTimeEnd)) {
                criteria.andBPressTimeBetween(sdf.parse(bPressTimeStart),sdf.parse(bPressTimeEnd));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        try{
            if (StringUtils.isNotEmpty(bAddTimeStart) && StringUtils.isNotEmpty(bAddTimeEnd)) {
                criteria.andBAddTimeBetween(sdf.parse(bAddTimeStart),sdf.parse(bAddTimeEnd));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotEmpty(bService)) {
            criteria.andBServiceEqualTo(bService);
        }
        if (StringUtils.isNotEmpty(bSaleNum)) {
            criteria.andBSaleNumEqualTo(Integer.parseInt(bSaleNum));
        }
        return example;
    }
    @Override
    public List<Books> selectByExample(BooksExample example, int pageNum, int pageSize)  {
        PageHelper.startPage(pageNum, pageSize);
        return dao.selectByExample(example);
    }

	@Override
	public List<Books> getNewsetBook(int count) {
		// TODO Auto-generated method stub
		return dao.getNewsetBook(count);
	}

	@Override
	public List<Books> getdiscountBook(int count) {
		// TODO Auto-generated method stub
		return dao.getdiscountBook(count);
	}

	@Override
	public List<Books> getBestSaleBook(int count) {
		// TODO Auto-generated method stub
		return dao.getBestSaleBook(count);
	}

	@Override
	public List<Books> getBookByConditions(String category, String saleNum, String discount, String newset, String price,
			Float lowestPrice, Float highestPrice) {
		// TODO Auto-generated method stub
		return dao.getBookByConditions(category, saleNum, discount, newset, price, lowestPrice, highestPrice);
	}

	@Override
	public List<Books> getdiscountBookWithLimit(int count) {
		// TODO Auto-generated method stub
		return dao.getdiscountBookWithLimit(count);
	}

	@Override
	public int updateBSaleNum(int bSaleNum, String bId) {
		// TODO Auto-generated method stub
		return dao.updateBSaleNum(bSaleNum, bId);
	}
}