package msg.app.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import msg.app.services.MsgReceiver;

@Profile("receiver")
@Configuration
public class ConsumerConfig {
		
	@Bean
	public MsgReceiver consumer1() {
		return new  MsgReceiver(1);
	}
	
	@Bean
	public MsgReceiver consumer2() {
		return new  MsgReceiver(2);
	}
	
	

}
