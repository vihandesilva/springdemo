package com.springdemo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.springddemo.publisher.RabbitMQProducer;
import com.springdemo.consumer.RabbitMQConsumer;

@Configuration
public class RabbitMQConfig {
	
	@Value("${spring.rabbitmq.queue.name}")
	private String queueName;
	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;
	@Value("${spring.rabbitmq.routing.key}")
	private String keyName;
	@Value("${spring.rabbitmq.jsonqueue.name}")
	private String jsonQueue;
	@Value("${spring.rabbitmq.routing.json}")
	private String jsonKey;
	
	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}
	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueue);
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(exchangeName);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter(new JsonMapper());
	}
	
	// Bind queue and Exchange using routing key
	public Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(topicExchange())
				.with(keyName);
	}
	
	// Bind JSON Queue and Exchange using routing key
	public Binding jsonBinding() {
		return BindingBuilder
				.bind(jsonQueue())
				.to(topicExchange())
				.with(jsonKey);
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
	}
	
}
