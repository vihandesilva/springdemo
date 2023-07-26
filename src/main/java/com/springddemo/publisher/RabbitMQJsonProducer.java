package com.springddemo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.springdemo.dto.User;

@Service
public class RabbitMQJsonProducer {
	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;
	@Value("${spring.rabbitmq.jsonqueue.name}")
	private String jsonQueue;
	@Value("${spring.rabbitmq.routing.json}")
	private String jsonKey;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
	
	private MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter(new JsonMapper());
	}
	
	public void sendUserJSON(User user) {
		rabbitTemplate.setMessageConverter(messageConverter());
		rabbitTemplate.convertAndSend(exchangeName, jsonKey, user);
	}
}
