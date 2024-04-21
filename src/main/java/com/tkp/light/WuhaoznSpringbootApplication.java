package com.tkp.light;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.tkp.light.mapper"})
public class WuhaoznSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuhaoznSpringbootApplication.class, args);
    }

}


