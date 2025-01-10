package com.bigf.furn;
import com.bigf.furn.bean.Furn;
import com.bigf.furn.mapper.FurnMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.bigf.furn"})//扫描所有mapper
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

