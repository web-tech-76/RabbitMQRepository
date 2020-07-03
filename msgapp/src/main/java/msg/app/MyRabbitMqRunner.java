package msg.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitMqRunner implements CommandLineRunner {

	@Autowired
	ConfigurableApplicationContext appContext;
	
	@Value(" ${rabbitmq.custom.duration:0 } ")
	private int duration;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ready to run ...... for " + duration + " ms duration");
		Thread.sleep(duration);
		appContext.close();
	}

}
