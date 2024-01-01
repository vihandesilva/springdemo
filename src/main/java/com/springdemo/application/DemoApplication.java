package com.springdemo.application;

<<<<<<< HEAD

import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.springddemo.publisher.RabbitMQJsonProducer;
import com.springddemo.publisher.RabbitMQProducer;
import com.springdemo.config.RabbitMQConfig;
import com.springdemo.controller.MessageController;

@SpringBootApplication
@ComponentScan(basePackages = "com.springdemo.controller")
public class DemoApplication {
	
	@Bean
	public RabbitMQConfig rabbitMQConfig() {
		return new RabbitMQConfig();
	}
	@Bean
	public RabbitMQProducer rabbitMQProducer() {
		return new RabbitMQProducer();
	}
	@Bean
	public RabbitMQJsonProducer rabbitMQJsonProducer() {
		return new RabbitMQJsonProducer();
	}
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class DemoApplication {

>>>>>>> 28e75aa (minor changes in controllers)
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
