package com.example.helloworld.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.helloworld"})
public class HelloworldApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(HelloworldApplication.class, args);
		for(String nameBean : ac.getBeanDefinitionNames()) {
			System.out.println(nameBean);
		}

	}

	@Bean
	public String getString() {
		return "Hello";
	}

	@Bean
	public HelloworldApplication getHello() {
		return new HelloworldApplication();
	}

}
