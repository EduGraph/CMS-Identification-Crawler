package write.TimeEvents;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class TimerService {
	@Schedule(second="*", minute="*", hour="*", persistent=false)
	public void doWork() {
		System.out.println("timer: Hello World");
	}
}
