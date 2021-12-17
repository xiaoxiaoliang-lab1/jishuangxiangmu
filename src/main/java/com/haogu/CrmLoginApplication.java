package com.haogu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.haogu.mapper")
public class CrmLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmLoginApplication.class, args);
    }

}
