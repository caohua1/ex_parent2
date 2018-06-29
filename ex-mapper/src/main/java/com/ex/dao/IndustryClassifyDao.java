package com.ex.dao;

import com.ex.entity.IndustryClassify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndustryClassifyDao {
    public Integer insertIndustry(IndustryClassify industryClassify);
    public List<IndustryClassify> selectIndustry(IndustryClassify industryClassify);
    public Integer selectIndustryCount(IndustryClassify industryClassify);
    public Integer updateIndustry(IndustryClassify industryClassify);
    public Integer deleteIndustry(Long id);
    public List<IndustryClassify> getAll();
}
