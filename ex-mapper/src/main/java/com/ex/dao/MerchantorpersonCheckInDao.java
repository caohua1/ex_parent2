package com.ex.dao;

import com.ex.entity.MerchantorpersonCheckIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    /**
     * 分页查询查询所有入驻信息
     * @return
     */
    List<MerchantorpersonCheckIn> findByPage();

    /**
     * 商家入驻
     * @param merchantorpersonCheckIn
     * @return
     */
    int insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn);

    /**
     * 按条件查询入驻信息
     * @param merchantorpersonCheckIn
     * @return
     */
    List<MerchantorpersonCheckIn> byConditionsQuery(@Param("record") MerchantorpersonCheckIn merchantorpersonCheckIn);

    /**
     * 按注册人Id和入住类型查询
     * @param merchantId
     * @param checkInType
     * @return
     */
    MerchantorpersonCheckIn selectByMerchantId(@Param("merchantId") Long merchantId,@Param("checkInType") int checkInType);

    /**
     * 修改入驻信息
     * @param merchantorpersonCheckIn
     * @return
     */
    int updateMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn);

    /**
     * 商家PC端审核
     * @param id
     * @param status
     * @param causeby
     * @return
     */
    int auditTheMerchant(Long id,int status,String causeby,Date updateTime);
}