package com.ex.service;
import com.ex.entity.IndustryAdvertising;
import com.ex.util.PageRequest;
import com.ex.vo.IndustryAdvertisingVo;
import com.github.pagehelper.PageInfo;


public interface IndustryAdvertisingService {
    public Integer insertIndustryAdvertising(IndustryAdvertising industryAdvertising);
    public PageInfo<IndustryAdvertisingVo> selectIndustryAdvertising(PageRequest pageRequest);
    public Integer selectIndustryAdvertisingCount();
    public Integer updateIndustryAdvertising(IndustryAdvertising industryAdvertising);
    public IndustryAdvertisingVo selectIndustryAdvertisingById(Long id);
}
