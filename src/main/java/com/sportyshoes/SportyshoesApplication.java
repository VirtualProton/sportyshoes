package com.sportyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(exclude={DataSourceAutoConfiguration.class})
public class SportyshoesApplication{

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApplication.class, args);
	}
} 
