package com.ex.dao;
import com.ex.entity.IndustryAdvertising;
import com.ex.vo.IndustryAdvertisingVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface IndustryAdvertisingDao {

    public Integer insertIndustryAdvertising(IndustryAdvertising industryAdvertising);
    public List<IndustryAdvertisingVo> selectIndustryAdvertising();
    public Integer selectIndustryAdvertisingCount();
    public Integer updateIndustryAdvertising(IndustryAdvertising industryAdvertising);
    public IndustryAdvertisingVo selectIndustryAdvertisingById(Long id);
}
