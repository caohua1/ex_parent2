package com.ex.service;

import com.ex.entity.MerchantRegist;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName MerchantRegistService
 * @Description TODO
 * @Author sanmu
 * @Date 2018/6/6 10:23
 * @Version 1.0
 **/
public interface MerchantRegistService {
    //商家注册
    boolean insertMerchantRegist(MerchantRegist merchantRegist);
    //商家登陆或校验商家名是否存在
    MerchantRegist merchantLoginOrCheckUserName(String username);
    //获取所有商家注册信息
    PageInfo<MerchantRegist> findByPage(PageRequest page);

}
