package com.learner.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
	private final KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "kafka-example";

	public void consume(String message) {
		kafkaTemplate.send(TOPIC, message);
	}
}
