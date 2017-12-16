package com.xiaour.xiuxiubizhi.service;

import java.util.List;

/**
 * Created by zhangtao on 2017/11/8.
 */

public interface RedisService {

     boolean set(String key, String value);

     String get(String key);

     boolean expire(String key,long expire);

     <T> boolean setList(String key ,List<T> list);

     <T> List<T> getList(String key,Class<T> clz);

     long lpush(String key,Object obj);

     long rpush(String key,Object obj);

     long hmset(String key,Object obj);

     String lpop(String key);
}
