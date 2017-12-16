package com.xiaour.xiuxiubizhi.service;

import java.util.List;

import com.xiaour.xiuxiubizhi.entity.Image;

public interface ImageService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
    
    List<Image> selectList(Image record);
    
    int clickViewCount(Integer id);
    
    int insertBatch(List<Image> list);

}
