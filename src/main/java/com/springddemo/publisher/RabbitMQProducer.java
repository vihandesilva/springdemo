package com.springddemo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.json.JsonMapper;


@Service
public class RabbitMQProducer {
	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;
	@Value("${spring.rabbitmq.routing.key}")
	private String keyName;
	@Value("${spring.rabbitmq.jsonqueue.name}")
	private String jsonQueue;
	@Value("${spring.rabbitmq.routing.json}")
	private String jsonKey;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);
	
	
	public void sendMessage(String message) {
		rabbitTemplate.convertAndSend(exchangeName, keyName, message);
		logger.info(String.format("Message sent to RabbitMQ Server. (Message: %s)", message));
	}
		
	
}
