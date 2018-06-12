package com.ex.dao;

import com.ex.entity.MerchantRegist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName ex_parent
 * @ClassName MerchantRegistDao
 * @Description TODO 商家注册表
 * @Author sanmu
 * @Date 2018/6/6 10:13
 * @Version 1.0
 **/

@Mapper
public interface MerchantRegistDao {
    List<MerchantRegist> findByPage();

    int insertMerchantRegist(MerchantRegist merchantRegist);

    MerchantRegist merchantLoginOrCheckUserName(@Param("username") String username);
}