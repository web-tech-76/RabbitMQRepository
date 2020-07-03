package rabbit.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitpubApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitpubApplication.class, args);
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
