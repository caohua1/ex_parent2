package com.ex.service;

import com.ex.entity.MerchantorpersonCheckIn;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;


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

}
