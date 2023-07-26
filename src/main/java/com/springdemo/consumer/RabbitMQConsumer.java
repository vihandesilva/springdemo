package com.springdemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	@RabbitListener(queues = {"${spring.rabbitmq.queue.name}"})
	public void consume(String message) {
		logger.info(String.format("Message recieved from RabbitMQ Server: %s", message));
	}

}
