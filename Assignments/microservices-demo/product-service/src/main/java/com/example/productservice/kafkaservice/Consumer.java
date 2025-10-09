package com.example.productservice.kafkaservice;

import org.springframework.kafka.annotation.KafkaListener; 
import org.springframework.stereotype.Service; 

@Service 
public class Consumer { 
	
	@KafkaListener(topics = "test", groupId = "hello-group2") 
	public void listen(String message) { 
		System.out.println("Product service..Received message: " + message); 
	} 
}
