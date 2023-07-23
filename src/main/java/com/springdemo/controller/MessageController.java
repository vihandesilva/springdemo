package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springddemo.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/messager/")
public class MessageController extends BaseController{
	private RabbitMQProducer producer;
	
	@Autowired
	public MessageController(RabbitMQProducer producer) {
		super();
		this.producer = producer;
	}
	
	@PostMapping("/message/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		producer.sendMessage(message);
		return ResponseEntity.ok("Message delivered to RabbitMQ");
	}

}
