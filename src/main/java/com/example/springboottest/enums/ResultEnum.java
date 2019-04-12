package com.example.springboottest.enums;

/**
 * @author lgm
 * @date 2018/10/10 21:25
 */
public enum ResultEnum {
    UNKONWERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你在上小学吧"),
    MIDDLE_SCHOOL(101,"你在上初中吧"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
