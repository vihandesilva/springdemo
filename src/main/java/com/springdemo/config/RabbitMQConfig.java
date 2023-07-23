package com.springdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${spring.rabbitmq.queue.name}")
	private String queueName;
	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;
	@Value("${spring.rabbitmq.routing.key}")
	private String keyName;
	
	public Queue queue() {
		return new Queue(queueName);
	}
	
	public TopicExchange topicExchange() {
		return new TopicExchange(exchangeName);
	}
	
	// Bind queue and Exchange using routing key
	public Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(topicExchange())
				.with(keyName);
	}
}
