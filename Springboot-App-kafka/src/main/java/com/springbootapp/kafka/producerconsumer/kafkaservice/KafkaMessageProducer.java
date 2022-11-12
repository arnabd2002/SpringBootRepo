package com.springbootapp.kafka.producerconsumer.kafkaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer
{
	private static final String topic="topic1";
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	
	public void sendMessage(String message)
	{
		System.out.println("Published message:"+message+" on topic:"+topic);
		kafkaTemplate.send(topic, message);
		
		
	}

}
