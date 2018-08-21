package com.ex;

import org.springframework.beans.factory.annotation.Autowired; import org.springframework.context.ApplicationListener; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.servlet.HandlerInterceptor;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    public MyScheduler myScheduler;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }
   
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try { myScheduler.scheduleJobs();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

     }



}
