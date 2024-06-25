package com.timer.util;

import com.timer.info.TimerInfo;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public final class TimerUtils {
    private static final Logger LOG = LoggerFactory.getLogger(TimerUtils.class);

    private TimerUtils() {}

    public static JobDetail buildJobDetail(final Class jobClass, final TimerInfo info) {
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), info);

        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .setJobData(jobDataMap)
                .build();
    }

    public static CronTrigger buildTrigger(final Class jobClass, final TimerInfo info) {
//        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(info.getRepeatIntervalMs());
//
//        if (info.isRunForever()) {
//            builder = builder.repeatForever();
//        } else {
//            builder = builder.withRepeatCount(info.getTotalFireCount() - 1);
//        }

        LOG.info("in TimerUtils.buildTrigger()");

        CronScheduleBuilder cron = cronSchedule("2 0/1 * * * ?");

        LOG.info(String.valueOf(newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(cron)
                .build()));


        return newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(cron)
                .build();
    }
}