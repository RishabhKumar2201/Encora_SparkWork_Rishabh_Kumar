package com.example.orderservice.kafkaservice;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    // Constructor injection of KafkaTemplate
    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Method to send a message to a Kafka topic
    public void sendMessage(String message) {
        kafkaTemplate.send("test", message);
        System.out.println("Sent message: " + message);
    }
}

