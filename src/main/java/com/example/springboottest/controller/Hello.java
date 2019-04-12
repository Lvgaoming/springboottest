package com.example.springboottest.controller;

import com.example.springboottest.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/mytest",method = RequestMethod.GET)
public class Hello {

    @Value("${msg}")
    private String cupSize;
    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;
    @RequestMapping(value = {"/hello/{id}","/hi"},method = RequestMethod.GET)
    public String say( @PathVariable("id") int id){

        return "<p>"+"hello spring boot"+"</p>"+"<p>"+cupSize+"</p>"+content+"<p>"+girlProperties.getAge()+"</p>"+"<p>"+"id:"+id+"</p>";
       //  return "index";
    }
}
