package msg.app.services;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "sendmsg")
public class MsgReceiver {

	private int instanceNum;
	
	public MsgReceiver() {
		super();
	}

	public MsgReceiver(int instanceNum) {
		this.instanceNum=instanceNum;
	}

	
	@RabbitHandler
	public void receive(String in) throws InterruptedException{

		//if (0==this.num) return ;
		
		StopWatch watch = new StopWatch();

		watch.start();
		System.out.println(" Message Received By ..... " + this.instanceNum+ " & Message Is: - " + in);
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
