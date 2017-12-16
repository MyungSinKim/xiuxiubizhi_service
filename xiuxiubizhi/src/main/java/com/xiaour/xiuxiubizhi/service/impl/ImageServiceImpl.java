package com.xiaour.xiuxiubizhi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaour.xiuxiubizhi.entity.Image;
import com.xiaour.xiuxiubizhi.mapper.ImageMapper;
import com.xiaour.xiuxiubizhi.service.ImageService;


@Service("imageService")
@Transactional(rollbackFor = Exception.class)
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageMapper imageMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Image record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Image selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Image record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Image record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Image> selectList(Image record) {
		return imageMapper.selectList(record);
	}

	@Override
	public int clickViewCount(Integer id) {
		return imageMapper.clickViewCount(id);
	}

	@Override
	public int insertBatch(List<Image> list) {
		return imageMapper.insertBatch(list);
	}

}
