package com.example.orderservice.kafkaservice;

import org.springframework.kafka.annotation.KafkaListener; 
import org.springframework.stereotype.Service; 

@Service
public class Consumer {
	
	@KafkaListener(topics = "test", groupId = "hello-group1")
	public void listen(String message) {
		System.out.println("Received message: " + message);
	}
}