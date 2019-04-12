package com.example.springboottest.service.impl;

import com.example.springboottest.mybatistest.dao.mapper.StudentMapper;
import com.example.springboottest.mybatistest.dao.model.Student;
import com.example.springboottest.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lgm
 * @date 2018/11/7 15:56
 */
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAllStudent();
    }
}
