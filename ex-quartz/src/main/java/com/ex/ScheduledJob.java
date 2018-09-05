package com.ex;
import com.ex.dao.UserBrowseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Date;

@SuppressWarnings("ALL")
@Controller
public class ScheduledJob {

    @Autowired
    private UserBrowseDao userBrowseDao;

     @Scheduled(cron = "0/2 * * * * *")
        public void excute1() {
        // TODO Auto-generated method stub
           try{
               Integer i = userBrowseDao.deleteBrowse();
               if(i>0){
                   System.out.println("删除了");
                   System.out.println("删除数据成功"+ new Date());
               }else{
                   System.out.println("未删除数据");
               }
           }catch(Exception e){
               e.printStackTrace();
           }
    }


}
