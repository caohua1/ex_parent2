package com.ex.service.impl;

import com.ex.dao.LogDao;
import com.ex.entity.Log;
import com.ex.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class LogSeviceImpl implements LogService {

    @Autowired
    private LogDao logDao;
    /**
     * 添加日志
     * @param operation
     * @param operationType
     * @param eventType
     * @param eventLevel
     * @param operationUser
     * @param operationTime
     * @param userIp
     * @param describe
     * @param result
     * @return
     */
    @Override
    public Integer insertLog(String operation,String operationType,Integer eventType,String eventLevel,String operationUser,Date operationTime,String userIp,String describe,Integer result) {
        Log log = new Log();
        log.setOperation(operation);
        log.setOperationType(operationType);
        log.setEventType(eventType);
        log.setEventLevel(eventLevel);
        log.setOperationUser(operationUser);
        log.setOperationTime(operationTime);
        log.setUserIp(userIp);
        log.setDescribe(describe);
        log.setResult(result);
        Integer i = logDao.insertLog(log);
        return i;
    }
}
