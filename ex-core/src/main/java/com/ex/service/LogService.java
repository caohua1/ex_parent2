package com.ex.service;

import java.util.Date;

public interface LogService {

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
    public Integer insertLog(String operation, String operationType, Integer eventType, String eventLevel, String operationUser, Date operationTime, String userIp, String describe, Integer result);
}
