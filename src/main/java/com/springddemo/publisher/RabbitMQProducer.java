package com.springddemo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQProducer {
	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;
	@Value("${spring.rabbitmq.routing.key}")
	private String keyName;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);
	
//	public RabbitMQProducer(RabbitTemplate template) {
//		super();
//		this.rabbitTemplate = template;
//	}
	
	public void sendMessage(String message) {
		rabbitTemplate.convertAndSend(exchangeName, keyName, message);
	}
	
	
	
	
}
