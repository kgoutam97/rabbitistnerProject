package com.rabbitMq.rabbitistnerProject;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqExcangeConfiguration {
	
	@Bean
	Exchange exampleExchange() {
		return new TopicExchange("exampleExchange");
	}
	
	@Bean
	Exchange example2Exchange() {
		return ExchangeBuilder.directExchange("example2Exchange")
				  .autoDelete()
				   .build();
	}
	
	@Bean
	Exchange headerEXChange() {
		return ExchangeBuilder.headersExchange("headersExchange")
				.internal()
				.durable(true)
				.ignoreDeclarationExceptions()
				.build();
	}

}
