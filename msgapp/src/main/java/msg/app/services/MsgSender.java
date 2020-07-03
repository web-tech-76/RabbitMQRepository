package msg.app.services;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


public class MsgSender {

	AtomicInteger dots = new AtomicInteger(0);
	AtomicInteger count = new AtomicInteger(0);

	
	public MsgSender() {
		super();
	}

	
	@Autowired
	private RabbitTemplate messageTemplate;

	
	@Autowired
	private Queue queue;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send() {

		StringBuilder strBuilder = new StringBuilder("hello");

		if (dots.incrementAndGet() == 3) {
			dots.set(1);
		}

		for (int i = 0; i <= dots.get(); i++) {
			strBuilder.append('.');
		}

		strBuilder.append(count.incrementAndGet());
		String message = strBuilder.toString();
		messageTemplate.convertAndSend(queue.getName(), message);
		System.out.println("  message sent :  " + message);

	}

}
