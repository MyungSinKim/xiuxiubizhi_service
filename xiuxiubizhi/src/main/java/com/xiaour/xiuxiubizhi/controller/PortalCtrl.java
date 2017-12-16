package com.xiaour.xiuxiubizhi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaour.xiuxiubizhi.constants.CacheKeys;
import com.xiaour.xiuxiubizhi.entity.Image;
import com.xiaour.xiuxiubizhi.service.ImageService;
import com.xiaour.xiuxiubizhi.service.RedisService;
import com.xiaour.xiuxiubizhi.utils.JsonResult;
import com.xiaour.xiuxiubizhi.utils.JsonUtil;

/**
 * Created by zhangtao on 2017/11/8.
 */

@RestController
@RequestMapping("/portal")
public class PortalCtrl {

    @Autowired
    private RedisService redisService;
    
    @Autowired
    private ImageService imageService;

    @RequestMapping(value="/set")
    public String ping(){
        String data="{\"code\":1,\"data\":\"请求成功！\",\"message\":\"成功\"}";
        redisService.set("TEST_JSON",data);
        return redisService.get("TEST_JSON");
    }

    @RequestMapping(value="/indexTopSlider")
    public String indexTopSlider(Integer pageNum){
    	String data=redisService.get(CacheKeys.INDEX_TOP_SLIDER);
    	List dataList= JsonUtil.readJson2Array(data ,Map.class);
        return JsonResult.successWithData(data);
    }
    
    @RequestMapping(value="/addIndexTopSlider")
    public String addIndexTopSlider(String json){
    	redisService.set(CacheKeys.INDEX_TOP_SLIDER, json);
        return JsonResult.emptySuccess();
    }
    
    @RequestMapping(value="/list")
    public String list(@RequestParam("pageNum") Integer pageNum){
    	System.out.println(pageNum);
    	Image img= new Image();
    	img.setStartNum(pageNum);
        List<Image> dataList=imageService.selectList(img);
        return JsonResult.successWithData(dataList);
    }
    
    @RequestMapping(value="/click")
    public String click(Integer id){
        imageService.clickViewCount(id);
        return JsonResult.emptySuccess();
    }
    
    

}
