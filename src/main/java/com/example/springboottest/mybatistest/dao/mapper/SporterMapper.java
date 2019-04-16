package com.example.springboottest.mybatistest.dao.mapper;

import com.example.springboottest.mybatistest.dao.model.Sporter;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface SporterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sporter record);

    int insertSelective(Sporter record);

    Sporter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sporter record);

    int updateByPrimaryKey(Sporter record);

    List<Sporter> selectAllSporter();
}