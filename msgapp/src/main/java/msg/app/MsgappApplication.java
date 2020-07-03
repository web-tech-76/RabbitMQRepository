package msg.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsgappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgappApplication.class, args);
	}
	
	@Profile("dev")
	@Bean
	public CommandLineRunner userThis(){
		
		return args -> {
			
			System.out.println(" Controlling the behavior of the progrma ");
				
		};
		
	}
	
	
	@Profile("!dev")
	@Bean
	public MyRabbitMqRunner customRunner() {
		return new MyRabbitMqRunner(); 
	}
	
	

}
