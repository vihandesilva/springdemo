package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springddemo.publisher.RabbitMQJsonProducer;
import com.springddemo.publisher.RabbitMQProducer;
import com.springdemo.dto.User;

@RestController
@RequestMapping("/jsonmessager/")
public class JsonMessageController extends BaseController{
	private RabbitMQJsonProducer jsonproducer;
	
	@Autowired
	public JsonMessageController(RabbitMQJsonProducer producer) {
		this.jsonproducer = producer;
	}
	
	@PostMapping("/user/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user){
		jsonproducer.sendUserJSON(user);
		return ResponseEntity.ok("JSON delivered to RabbitMQ. (JSON: " + user +" )");
	}

}