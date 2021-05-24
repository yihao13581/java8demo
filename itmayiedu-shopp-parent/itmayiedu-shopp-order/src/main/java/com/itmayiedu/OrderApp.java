package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @CLassName OrderAPP
 * @Description: TODO
 * @date: 2019/12/30 17:32
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderApp {
	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class,args);
	}
}
