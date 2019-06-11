package com.yc.datademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DatademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatademoApplication.class, args);
	}

}
