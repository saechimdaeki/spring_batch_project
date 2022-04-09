package me.saechimdaeki.batch.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;

@Component
@Slf4j
public class ApiJobRunner extends JobRunner {

    @Autowired
    private Scheduler scheduler;

    @Override
    protected void doRun(ApplicationArguments args) {
        JobDetail jobDetail= buildJobDetail(ApiSchJob.class, "apiJob","batch",new HashMap());
        Trigger trigger= buildJobTrigger("0/30 * * * * ?");

        try{
            scheduler.scheduleJob(jobDetail,trigger);
        }catch (SchedulerException e){
            log.error("Error ",e);
        }
    }

}
