package com.bookshop.serviceImpl;import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookshop.service.BookImagesService;
import com.bookshop.modle.BookImages;
import com.bookshop.modle.BookImagesExample;
import com.bookshop.dao.BookImagesMapper;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
@Service("bookImagesService")
public class BookImagesServiceImpl implements BookImagesService {
    @Autowired
    BookImagesMapper dao;
    @Override
    public int countByExample(BookImagesExample example){
        return (int)dao.countByExample(example);
    }
    @Override
    public int deleteByExample(BookImagesExample example){
        return dao.deleteByExample(example);
    }
    @Override
    public int insert(BookImages record)  {
        return dao.insert(record);
    }
    @Override
    public int insertSelective(BookImages record)  {
        return dao.insertSelective(record);
    }
    @Override
    public List<BookImages> selectByExample(BookImagesExample example)  {
        return dao.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(@Param("record") BookImages record, @Param("example") BookImagesExample example)  {
        return dao.updateByExampleSelective(record, example);
    }
    @Override
    public int updateByExample(@Param("record") BookImages record, @Param("example") BookImagesExample example)  {
        return dao.updateByExample(record, example);
    }
    @Override
    public BookImages createBookImages(Map<String, String>req) {
        String bId = req.get("bId");
        String bImg = req.get("bImg");
        BookImages bookImages = new BookImages();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isNotEmpty(bId)) {
            bookImages.setbId(bId);
        }
        if (StringUtils.isNotEmpty(bImg)) {
            bookImages.setbImg(bImg);
        }
        return bookImages;
    }
    @Override
    public BookImagesExample createBookImagesExm(Map<String, String>req){
        String bId = req.get("bId");
        String bImg = req.get("bImg");
        BookImagesExample example = new BookImagesExample();
        BookImagesExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(bId)) {
            criteria.andBIdEqualTo(bId);
        }
        if (StringUtils.isNotEmpty(bImg)) {
            criteria.andBImgEqualTo(bImg);
        }
        return example;
    }
    @Override
    public List<BookImages> selectByExample(BookImagesExample example, int pageNum, int pageSize)  {
        PageHelper.startPage(pageNum, pageSize);
        return dao.selectByExample(example);
    }
}