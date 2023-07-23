package com.springdemo.application;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.springddemo.publisher.RabbitMQProducer;
import com.springdemo.controller.MessageController;

@SpringBootApplication
@ComponentScan(basePackages = "com.springdemo.controller")
public class DemoApplication {
	
	@Bean
	public RabbitMQProducer rabbitMQProducer() {
		return new RabbitMQProducer();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
