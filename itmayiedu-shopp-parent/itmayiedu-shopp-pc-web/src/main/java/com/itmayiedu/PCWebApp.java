package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @CLassName PCWebApp
 * @Description: TODO
 * @date: 2019/12/18 20:58
 * @Version 1.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class PCWebApp {

	 public static void main(String[] args) {
		 SpringApplication.run(PCWebApp.class, args);
	}
	
}
