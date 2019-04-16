package com.example.springboottest.service;

import com.example.springboottest.mybatistest.dao.model.Sporter;

import java.util.List;

/**
 * @author lgm
 * @date 2019/4/15 16:40
 */
public interface SporterService {
    List<Sporter> getAllSporter();
}
