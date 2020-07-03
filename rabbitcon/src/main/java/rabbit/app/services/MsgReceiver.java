package rabbit.app.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Profile("receiver")
@Service
public class MsgReceiver {

	public MsgReceiver() {
		super();
	}
	
	@RabbitListener(queues = "#{autoDeleteQueue1.name}")
	public void receive1(String in) throws InterruptedException {
		receive(in, 1);
	}
	
	
	@RabbitListener(queues = "#{autoDeleteQueue2.name}")
	public void receive2(String in) throws InterruptedException {
		receive(in, 2);
	}
	
		
	public void receive(String in, int receiver) throws InterruptedException{

		//if (0==this.num) return ;
		
		StopWatch watch = new StopWatch();

		watch.start();
		System.out.println(" Message Received By ..... " + receiver + " & Message Is: -  " + in);
		dosomeWork(in);
		watch.stop();

		//System.out.println("instance :- " + this.num + " done in : " + watch.getTotalTimeSeconds() + "s");
	}

	private void dosomeWork(String in) throws InterruptedException {

		
			for (char ch : in.toCharArray()) {
				if (ch == '.')
					Thread.sleep(1000);
			}

		
	}

}
