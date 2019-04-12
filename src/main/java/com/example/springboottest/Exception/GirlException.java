package com.example.springboottest.Exception;

import com.example.springboottest.enums.ResultEnum;

/**
 * @author lgm
 * @date 2018/10/10 20:55
 */
public class GirlException extends RuntimeException {
    private Integer code;
    public GirlException(ResultEnum resultEnum){
          super(resultEnum.getMsg());
          this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
