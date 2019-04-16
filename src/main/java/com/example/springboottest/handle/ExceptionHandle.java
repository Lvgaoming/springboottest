package com.example.springboottest.handle;

import com.example.springboottest.Exception.GirlException;
import com.example.springboottest.domain.Result;
import com.example.springboottest.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lgm
 * @date 2018/10/10 19:26
 */

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            return ResultUtil.error(103,e.getMessage());
        }

    }
}
