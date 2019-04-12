package com.example.springboottest.controller;

import com.example.springboottest.mybatistest.dao.mapper.StudentMapper;
import com.example.springboottest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/students/")
    public Object students(){
      return studentMapper.selectAllStudent();
    }
}
