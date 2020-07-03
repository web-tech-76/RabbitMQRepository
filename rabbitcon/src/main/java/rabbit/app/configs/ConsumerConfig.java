package rabbit.app.configs;


import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import rabbit.app.services.MsgReceiver;


@Profile("pub-sub")
@Configuration
public class ConsumerConfig {
	
	
	/*
	 * @Bean public FanoutExchange fanOut() { return new
	 * FanoutExchange("amq.fanout"); }
	 */
	
	
	@Bean
	public TopicExchange  topicExchange() {
		return new TopicExchange("amq.topic");
	}
	
	
	@Bean
	public Queue autoDeleteQueue1() {
		return new AnonymousQueue();
	}
	
	@Bean
	public Queue  autoDeleteQueue2() {
		return new  AnonymousQueue();
	}
	
	
	

	@Bean
	public Binding binding1(TopicExchange topicExchange, Queue autoDeleteQueue1) {
		return BindingBuilder
				.bind(autoDeleteQueue1)
				.to(topicExchange)
				.with("*.orange.*")
				;
	}
	
	@Bean
	public Binding binding2(TopicExchange topicExchange, Queue autoDeleteQueue2) {
		return BindingBuilder
				.bind(autoDeleteQueue2)
				.to(topicExchange)
				.with("*.*.rabbit")
				;
	}
	
	@Bean
	public Binding binding3(TopicExchange topicExchange, Queue autoDeleteQueue2) {
		return BindingBuilder
				.bind(autoDeleteQueue2)
				.to(topicExchange)
				.with("lazy.#")
				;
	}
	
	
	
	
	@Bean
	public MsgReceiver consumer() {
		return new MsgReceiver();
	}

}
