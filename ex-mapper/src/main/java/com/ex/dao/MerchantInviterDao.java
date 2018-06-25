package com.ex.dao;

import com.ex.entity.MerchantInviter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MerchantInviterDao {

    /**
     * 生成邀请码
     * @param merchantInviter
     * @return
     */
    int insertMerchantInviter(MerchantInviter merchantInviter);

    /**
     * 按条件查询邀请码信息
     * @param merchantInviter
     * @return
     */
    List<MerchantInviter> byConditionsQuery(@Param("record") MerchantInviter merchantInviter);

    /**
     * 按商家id查询邀请码
     * @return
     */
    MerchantInviter selectInvitercodeByMerchantid(@Param("invitermerchantid") Long invitermerchantid);

    /**
     * 按商家id查询邀请码
     * @return
     */
    MerchantInviter selectInvitercodeByInvitercode(@Param("invitercode") Long invitercode);

    /**
     * 修改邀请码状态
     * @param merchantInviter
     * @return
     */
    int updateInvitercode(MerchantInviter merchantInviter);
}
