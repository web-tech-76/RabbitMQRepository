package rabbit.app.configs;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import rabbit.app.services.MsgSender;

@Profile( {"pub-sub"})
@Configuration
public class MessageConfig {

	
	/*
	 * @Bean public FanoutExchange fanOut() { return new
	 * FanoutExchange("amq.fanout"); }
	 */
	
	
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("amq.topic");
	}
	
	
	@Bean
	public MsgSender producer() {
		return new  MsgSender();
	}
	
	
	
	
	
}
