package com.yjw.basic.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by yjw on 18-9-30.
 */
public class SimpleTriggerRunner {
    public static void main(String[] args) {
        try {
            JobDetail jobDetail = new JobDetail("job_1", "jgroup1", SimpleJob.class);
            SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1", "tgroup1");
            simpleTrigger.setStartTime(new Date(System.currentTimeMillis()+6000L));
            simpleTrigger.setRepeatInterval(2000);
            simpleTrigger.setRepeatCount(100);
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, simpleTrigger);
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
