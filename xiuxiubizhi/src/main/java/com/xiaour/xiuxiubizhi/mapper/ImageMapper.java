package com.xiaour.xiuxiubizhi.mapper;

import com.xiaour.xiuxiubizhi.entity.Image;
import java.util.List;

public interface ImageMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
    
    List<Image> selectList(Image record);
    
    int clickViewCount(Integer id);
    
    int insertBatch(List<Image> list);
}