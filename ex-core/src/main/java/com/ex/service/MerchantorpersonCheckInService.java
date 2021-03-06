package com.ex.service;

import com.ex.entity.IndustryClassify;
import com.ex.entity.MerchantorpersonCheckIn;
import com.ex.util.PageRequest;
import com.ex.vo.MerchantCheckInVo;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @ClassName MerchantorpersonCheckInService
 * @Description TODO
 * @Author sanmu
 * @Date 2018/6/8 16:07
 * @Version 1.0
 **/
public interface MerchantorpersonCheckInService {

    PageInfo<MerchantorpersonCheckIn> findByPage(PageRequest page);

    int insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn);

    PageInfo<MerchantorpersonCheckIn> byConditionsQuery(PageRequest page,MerchantorpersonCheckIn merchantorpersonCheckIn);

    MerchantorpersonCheckIn selectByMerchantId(Long merchantId, Integer checkInType);

    int updateMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn);

    int auditTheMerchant(long id,int status,String causeby, Date updateTime);

    List<IndustryClassify> getIndustryClassifyAll();

    //=============================后台商家管理
    /**
     * 查询商家列表（入驻信息）
     * @param map
     * @return
     */
    public PageInfo<MerchantCheckInVo> selectMerchantList(Map map,PageRequest pageRequest);

    /**
     * 根据id查询商家详情
     * @param id
     * @return
     */
    public MerchantCheckInVo selectMerchantById(Long id);
}
