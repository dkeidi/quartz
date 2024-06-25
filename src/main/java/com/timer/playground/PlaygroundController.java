package com.timer.playground;

import com.timer.info.TimerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timer")
public class PlaygroundController {

    private final PlaygroundService service;
    private static final Logger LOG = LoggerFactory.getLogger(PlaygroundController.class);

    @Autowired
    public PlaygroundController(PlaygroundService service) {
        this.service = service;
    }

    //HelloWorldJob
    @PostMapping("/runhelloworld")
    public void runHelloWorldJob() {
        service.runHelloWorldJob();
    }

    // get localhost:8080/api/timer
    @GetMapping
    public List<TimerInfo> getAllRunningTimers() {
        return service.getAllRunningTimers();
    }

    @GetMapping("/{timerId}")
    public TimerInfo getRunningTimer(@PathVariable("timerId") String timerId) {
        LOG.error(timerId);
        return service.getRunningTimer(timerId);
    }

    @DeleteMapping("/{timerId}")
    public Boolean deleteTimer(@PathVariable("timerId") String timerId) {
        return service.deleteTimer(timerId);
    }


    //TransferJob
    @PostMapping("/runtransfer")
    public void runTransferJob() {
        service.runTransferJob();
    }
}