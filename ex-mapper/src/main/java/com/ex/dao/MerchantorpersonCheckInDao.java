package com.ex.dao;

import com.ex.entity.MerchantorpersonCheckIn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName ex_parent
 * @ClassName MerchantorpersonCheckInDao
 * @Description TODO 商家入驻表
 * @Author sanmu
 * @Date 2018/6/8 15:05
 * @Version 1.0
 **/
@Mapper
public interface MerchantorpersonCheckInDao {

    List<MerchantorpersonCheckIn> findByPage();

    int insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn);

}
