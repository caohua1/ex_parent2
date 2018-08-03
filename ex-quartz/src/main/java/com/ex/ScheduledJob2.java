package com.ex;
import com.ex.dao.UserBrowseDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class ScheduledJob2 implements Job{
    @Autowired
    private UserBrowseDao userBrowseDao;
    @Override
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
