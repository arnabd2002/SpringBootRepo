package com.springbootapp.kafka.producerconsumer.kafkaservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer
{
	
	@KafkaListener(topics="topic1", groupId = "0")
	public void consumeMessage(String message)
	{
		System.out.println("Consumed message:"+message+" from topic topic1");
	}

}
