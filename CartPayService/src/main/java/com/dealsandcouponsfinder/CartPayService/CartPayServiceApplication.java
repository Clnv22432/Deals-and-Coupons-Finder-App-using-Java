package com.dealsandcouponsfinder.CartPayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class CartPayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartPayServiceApplication.class, args);
	}

}
