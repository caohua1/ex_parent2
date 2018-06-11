package com.ex.dao;


import com.ex.entity.IdCardInfo;

import java.util.List;

public interface IdCardInfoDao {
    List<IdCardInfo> findByPage();

    int insertIdCardInfo(IdCardInfo idCardInfo);

    List<IdCardInfo> byConditionsQuery(IdCardInfo idCardInfo);
}
