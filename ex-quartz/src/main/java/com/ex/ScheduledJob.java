package com.ex;

import com.ex.dao.OrdersDao;
import org.quartz.Job; import org.quartz.JobExecutionContext; import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class ScheduledJob implements Job{
    @Autowired
    private OrdersDao  ordersDao;
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        // TODO Auto-generated method stub


    }

    }
