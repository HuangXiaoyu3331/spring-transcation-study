package com.hxy.springtranscation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxy.springtranscation.mapper")
public class SpringTranscationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTranscationApplication.class, args);
    }

}
