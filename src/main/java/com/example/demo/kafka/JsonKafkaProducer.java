package com.example.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import payload.User;

@Service
public class JsonKafkaProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, User> kafkatemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkatemplate) {
		this.kafkatemplate = kafkatemplate;
	}

	public void sendMessage(User user) {
		logger.info(String.format("Message sent -> %s", user.toString()));

	        Message<User> message = MessageBuilder
	                .withPayload(user)
	                .setHeader(KafkaHeaders.TOPIC, "javaguides-json")
	                .build();

	        kafkatemplate.send(message);
	}
	
}
