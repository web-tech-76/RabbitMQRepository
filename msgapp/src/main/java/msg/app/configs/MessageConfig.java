package msg.app.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import msg.app.services.MsgSender;

@Profile( {"msg", "sendmsg" })
@Configuration
public class MessageConfig {

	
	
	@Bean
	public Queue queue()
	{
		return new Queue("sendmsg");
	
	}
	
	@Profile("sender")
	@Bean
	public MsgSender producer() {
		return new  MsgSender();
	}
	
	
	
	
	
}
