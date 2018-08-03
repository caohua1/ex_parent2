package com.ex;
import com.ex.dao.UserBrowseDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ScheduledJob2 implements Job {
    @Autowired
    private UserBrowseDao userBrowseDao;
    @Override
    @Transactional
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        // TODO Auto-generated method stub
           try{
               Integer i = userBrowseDao.deleteBrowse();
               if(i>0){
                   System.out.println("删除数据成功");
               }
           }catch(Exception e){
               e.printStackTrace();
           }

    }

}
