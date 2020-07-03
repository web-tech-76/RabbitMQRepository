package rabbit.app.services;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Profile("sender")
@Component
public class MsgSender {

	AtomicInteger index = new AtomicInteger(0);
	AtomicInteger count = new AtomicInteger(0);

	
	public MsgSender() {
		super();
	}

	
	@Autowired
	private RabbitTemplate messageTemplate;

	
	/*
	 * @Autowired private FanoutExchange fanOut;
	 */

	@Autowired
	private TopicExchange topicExchange;
	
	
	String [] keys = {"quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};
	
	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send() {

		StringBuilder strBuilder = new StringBuilder("Hello to ");

		if (this.index.incrementAndGet() == keys.length) {
			this.index.set(0);
		}

		
		String key = keys[this.index.get()];
		
		strBuilder.append(key).append(" ").append(this.count.incrementAndGet());
		String message = strBuilder.toString();
		messageTemplate.convertAndSend(topicExchange.getName(), key, message);
		System.out.println("  message sent :  " + message);

	}

}
