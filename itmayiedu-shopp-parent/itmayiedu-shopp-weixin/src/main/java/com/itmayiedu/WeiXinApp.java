package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @CLassName weiXinApp
 * @Description: TODO
 * @date: 2019/12/20 11:39
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class WeiXinApp {

	public static void main(String[] args) {
		SpringApplication.run(WeiXinApp.class, args);
	}

}
