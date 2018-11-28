package ccpg.lj.quartz_demo.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution    //是否并发执行：加上该注释为false，即第一个任务执行完之后才执行下一个
public class MyTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务开始");
        try{
            Thread.sleep(6000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("任务结束");
    }
}
