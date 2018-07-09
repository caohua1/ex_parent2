package com.ex.dao;
import com.ex.entity.IndexAdvertising;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexAdvertisingDao {

    public Integer insertAdvertising(IndexAdvertising indexAdvertising);
    public List<IndexAdvertising> selectAdvertising();
    public Integer selectAdvertisingCount();
    public Integer updateAdvertising(IndexAdvertising indexAdvertising);
    public IndexAdvertising selectAdvertisingById(Long id);
}
