package com.ex.service;
import com.ex.entity.IndexAdvertising;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


public interface IndexAdvertisingService {

    public Integer insertAdvertising(IndexAdvertising indexAdvertising);
    public PageInfo<IndexAdvertising> selectAdvertising(PageRequest pageRequest);
    public Integer selectAdvertisingCount();
    public Integer updateAdvertising(IndexAdvertising indexAdvertising);
    public IndexAdvertising selectAdvertisingById(Long id);
}
