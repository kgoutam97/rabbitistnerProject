package com.rabbitMq.rabbitistnerProject;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
	
	private static final String MY_QUEUE="TestQueue";
	
	@Bean
	public Queue myQueue() {
		return new Queue(MY_QUEUE,true);
	}
	
	@Bean
	Exchange example6Exchange() {
		return ExchangeBuilder.topicExchange("myTopicExchange")
				.durable(true)
				   .build();
	}
	
	@Bean
	Binding binding() {
		//return new Binding(MY_QUEUE,Binding.DestinationType.QUEUE,"myTopicExchange","topic" , null);
		return BindingBuilder
				.bind(myQueue())
				.to(example6Exchange())
				.with("topic")
				.noargs();
		
	}
	
	
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory=new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername("gk");
		cachingConnectionFactory.setPassword("gk");
		return  cachingConnectionFactory;
		
	}
	
	@Bean
   public SimpleMessageListenerContainer messageListener() {
		SimpleMessageListenerContainer simpleMessageListenerContainer=new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setQueues(myQueue());
		simpleMessageListenerContainer.setMessageListener(new RabbitMqMessageListener());
		return simpleMessageListenerContainer;
		
		
		
	}

}
