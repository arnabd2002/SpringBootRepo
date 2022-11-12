package com.springbootapp.kafka.producerconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.kafka.producerconsumer.kafkaservice.KafkaMessageProducer;

@RestController
public class KafkaController 
{
	
	@Autowired
	KafkaMessageProducer k_producer;
	
	
	@PostMapping("/send")
	public void sendMessage(@RequestParam("msg") String msg)
	{
		k_producer.sendMessage(msg);
	}

}
