package com.learner.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	@KafkaListener(topics = "kafka_example", groupId = "")
	public void consume(Object message) {

	}
}
