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
public class FileJobRunner extends JobRunner {

    @Autowired
    private Scheduler scheduler;

    @Override
    protected void doRun(ApplicationArguments args) {

        String[] sourceArgs = args.getSourceArgs(); //Program Argument에 requestDate를 숫자만 적어서 실행할 것

        JobDetail jobDetail= buildJobDetail(FileSchJob.class, "apiJob","batch",new HashMap());
        Trigger trigger= buildJobTrigger("0/50 * * * * ?");

        jobDetail.getJobDataMap().put("requestDate",sourceArgs[0]); //하나만 전달할 것 임.


        try{
            scheduler.scheduleJob(jobDetail,trigger);
        }catch (SchedulerException e){
            log.error("Error ",e);
        }
    }

}
