package com.sapient.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import com.sapient.kafkademo.model.TaskStatus;
import com.sapient.kafkademo.model.TaskStatus.Status;

@SpringBootApplication
public class KafkademoApplication implements CommandLineRunner {

	@Autowired
	KafkaTemplate kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkademoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		kafkaTemplate.send("general-task-topic", "taskId", new TaskStatus("taskId", "taskName", 50.0f, Status.RUNNING));
		kafkaTemplate.send("general-task-topic", "taskId",
				new TaskStatus("taskId", "taskName", 100.0f, Status.FINISHED));

	}

}
