package com.ex.service;

import com.ex.entity.IndustryClassify;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


public interface IndustryClassifyService {

    public Integer insertIndustry(IndustryClassify industryClassify);
    public PageInfo<IndustryClassify> selectIndustry(IndustryClassify industryClassify, PageRequest pageRequest);
    public Integer selectIndustryCount(IndustryClassify industryClassify);
    public Integer updateIndustry(IndustryClassify industryClassify);
    public Integer deleteIndustry(Long id);
}
