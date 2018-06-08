package com.ex.dao;

import com.ex.entity.PaidLlistingManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaidLlistingManageDao {

    public List<PaidLlistingManage> selectPaidLlisting(Map conditionMap);

    public int delectPaidLlisting(Long id);
}
