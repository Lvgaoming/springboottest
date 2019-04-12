package com.example.springboottest;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class SpringboottestApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringboottestApplication.class);
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
