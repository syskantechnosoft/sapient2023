package com.sapient.kafkademo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.sapient.kafkademo.model.TaskStatus;

import lombok.extern.java.Log;

@Component
@Log
public class KafkaConsumerService {

	private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = { "general-task-topic" }, groupId = "task-group")
	public void consume(TaskStatus taskStatus) {

		logger.info(String.format("Task status is updated : " + taskStatus));
	}
}
