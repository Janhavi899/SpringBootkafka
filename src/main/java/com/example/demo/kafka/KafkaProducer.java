package com.example.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

	//Spring boot provide auto confgration we just need inject the template in the bean
	private KafkaTemplate<String, String> kafkatemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkatemplate) {
		this.kafkatemplate = kafkatemplate;
	}
	
	public void sendMessage(String message) {
		logger.info(String.format("Message sent %s", message));
		kafkatemplate.send("javaguides", message);
	}
}
