package com.example.springboottest.controller;

import com.example.springboottest.mybatistest.dao.mapper.SporterMapper;
import com.example.springboottest.mybatistest.dao.mapper.StudentMapper;
import com.example.springboottest.mybatistest.dao.model.Sporter;
import com.example.springboottest.service.SporterService;
import com.example.springboottest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lgm
 * @date 2018/11/7 15:54
 */
@RestController
public class MybatisController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private SporterMapper sporterMapper;

    @Autowired
    private SporterService sporterService;

//    注入springboot自动配置好的RedisTemplate



    @GetMapping(value = "/sporter")
    public List<Sporter> students(){

        ExecutorService executorService =Executors.newFixedThreadPool(25);

        for (int i = 1; i <=10000 ; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    sporterService.getAllSporter();
                }
            });
        }

        return sporterService.getAllSporter();
    }

    @GetMapping(value = "/sporter2")
    public List<Sporter> students2(){

        return sporterMapper.selectAllSporter();
    }
}
