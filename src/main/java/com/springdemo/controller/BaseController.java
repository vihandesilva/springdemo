package com.springdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class BaseController {
	
	@GetMapping("/hello")
	public ResponseEntity<String> sendMessage(){
		return ResponseEntity.ok("Welcome to Spring Demo Application.");
	}
}
