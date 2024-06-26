package com.timer.playground;

import com.timer.info.TimerInfo;
import com.timer.jobs.HelloWorldJob;
import com.timer.jobs.TransferJob;
import com.timer.timerservice.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {
    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob() {
        final TimerInfo info = new TimerInfo();
//        info.setTotalFireCount(5);
//        info.setRemainingFireCount(info.getTotalFireCount());
//        info.setRepeatIntervalMs(5000);
//        info.setInitialOffsetMs(1000);
//        info.setCallbackData("My callback data");

        scheduler.schedule(HelloWorldJob.class, info);
    }

    public void runTransferJob() {
        final TimerInfo info = new TimerInfo();
        info.setTotalFireCount(1);
        info.setRemainingFireCount(info.getTotalFireCount());
        info.setRepeatIntervalMs(5000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("Done?");

        scheduler.schedule(TransferJob.class, info);
    }

    public Boolean deleteTimer(final String timerId) {
        return scheduler.deleteTimer(timerId);
    }

    public List<TimerInfo> getAllRunningTimers() {
        return scheduler.getAllRunningTimers();
    }

    public TimerInfo getRunningTimer(final String timerId) {
        return scheduler.getRunningTimer(timerId);
    }
}