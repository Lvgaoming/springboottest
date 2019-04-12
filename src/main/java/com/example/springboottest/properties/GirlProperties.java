package com.example.springboottest.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author lgm
 * @date 2018/10/8 8:26
 * prefix = "girl" 的意思是yml文件中前缀是girl的的配置
 */
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cupSize;
    private int age;

    public GirlProperties() {
    }

    public String getCupSize(){
        return cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
