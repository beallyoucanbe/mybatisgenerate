package com.shuoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shuoyi"})
public class MybatisgenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisgenerateApplication.class, args);
	}
}
