package com.ldh.express;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * web项目启动类
 * @author Li Dehuan
 * @date 2019年2月1日
 *
 */
@MapperScan(basePackages={"com.ldh.express.base.core","com.ldh.express.dao.*"})
@SpringBootApplication
public class WebApp {

	public static void main(String[] args) {
		
		SpringApplication.run(WebApp.class, args);
	}
}
