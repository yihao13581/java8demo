package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @CLassName PayApp
 * @Description: TODO
 * @Author: sh
 * @date: 2019/12/26 11:38
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class PayApp {

	public static void main(String[] args) {
		SpringApplication.run(PayApp.class, args);
	}
	
}
