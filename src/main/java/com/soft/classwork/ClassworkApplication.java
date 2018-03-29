package com.soft.classwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.soft.classwork.mapper")
public class ClassworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassworkApplication.class, args);
	}
}
