package com.example.springboottest.service;

import com.example.springboottest.mybatistest.dao.model.Student;

import java.util.List;

/**
 * @author lgm
 * @date 2018/11/7 15:58
 */
public interface StudentService {
    public List<Student> getAllStudents();
}
