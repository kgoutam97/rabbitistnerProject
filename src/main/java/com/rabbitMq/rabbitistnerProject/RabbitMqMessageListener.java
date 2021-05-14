package com.rabbitMq.rabbitistnerProject;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMqMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		System.out.println(new String(message.getBody())+"------------");
		
	}
	
	

}
