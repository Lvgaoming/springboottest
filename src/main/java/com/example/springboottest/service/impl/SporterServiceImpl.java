package com.example.springboottest.service.impl;

import com.example.springboottest.mybatistest.dao.mapper.SporterMapper;
import com.example.springboottest.mybatistest.dao.model.Sporter;
import com.example.springboottest.service.SporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lgm
 * @date 2019/4/16 10:21
 */
@Service
public class SporterServiceImpl implements SporterService {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private SporterMapper sporterMapper;

    @Override
    public List<Sporter> getAllSporter() {
        //字符串序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        List<Sporter> sporters =(List<Sporter>) redisTemplate.opsForValue().get("allSporters");

//        双重检测锁
        if (sporters==null){
            synchronized (this){
                //从redis获取一下
                sporters =(List<Sporter>) redisTemplate.opsForValue().get("allSporters");
                if (sporters==null){
                    System.out.println("查询数据库。。。。");
                    //缓存为空，查询一遍数据库
                    sporters=sporterMapper.selectAllSporter();
                    redisTemplate.opsForValue().set("allSporters",sporters);
                }else {
                    System.out.println("进锁，查询缓存。。。");
                }

            }

        }else {
            System.out.println("查询缓存。。。。");
        }
        return sporters;
    }
}
