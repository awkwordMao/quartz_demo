package ccpg.lj.quartz_demo.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail myTaskDetail() {
        return JobBuilder.newJob(MyTask.class).withIdentity("myTask").storeDurably().build();
    }

    @Bean
    public Trigger myTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(myTaskDetail()).withIdentity("myTask").withSchedule(scheduleBuilder).build();
    }

}
