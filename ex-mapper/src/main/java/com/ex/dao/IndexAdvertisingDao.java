package com.ex.dao;
import com.ex.entity.IndexAdvertising;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IndexAdvertisingDao {

    public Integer insertAdvertising(IndexAdvertising indexAdvertising);
    public List<IndexAdvertising> selectAdvertising(Map map);
    public Integer selectAdvertisingCount(Map map);
    public Integer updateAdvertising(IndexAdvertising indexAdvertising);
    public IndexAdvertising selectAdvertisingById(Long id);
}
