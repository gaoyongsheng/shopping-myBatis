package com.shopping.demo;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.shopping.demo.mapper") // 指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
public class ShoppingDemoMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingDemoMybatisApplication.class, args);
    }



}
