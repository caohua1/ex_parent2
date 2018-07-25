package com.ex.service;
import com.ex.entity.IndexAdvertising;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.Map;


public interface IndexAdvertisingService {

    public Integer insertAdvertising(IndexAdvertising indexAdvertising);
    public PageInfo<IndexAdvertising> selectAdvertising(Map map,PageRequest pageRequest);
    public Integer selectAdvertisingCount(Map map);
    public Integer updateAdvertising(IndexAdvertising indexAdvertising);
    public IndexAdvertising selectAdvertisingById(Long id);
}
