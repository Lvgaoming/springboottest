package com.example.springboottest.utils;

import com.example.springboottest.domain.Girl;
import com.example.springboottest.repository.GirlRepository;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author lgm
 * @date 2018/11/6 14:53
 */
public class PoiTest {
    @Autowired
    private GirlRepository girlRepository;


    public static void main(String[] args) throws IOException {



    }
}
