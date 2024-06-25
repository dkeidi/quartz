package com.timer;

import com.timer.info.TimerInfo;
import com.timer.jobs.HelloWorldJob;
import com.timer.timerservice.SchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimerApplication {
	private static final Logger LOG = LoggerFactory.getLogger(TimerApplication.class);

	private final SchedulerService scheduler;

	@Autowired
	public TimerApplication(SchedulerService scheduler) {
		this.scheduler = scheduler;
	}

	public static void main(String[] args) {
		SpringApplication.run(TimerApplication.class, args).getBean(TimerApplication.class).runHelloWorldJob();
	}

	public void runHelloWorldJob() {
		LOG.info("schedule job");
		final TimerInfo info = new TimerInfo();
		scheduler.schedule(HelloWorldJob.class, info);
	}
}
