package com.ex.service;

import com.ex.entity.ShareProduct;
import com.ex.vo.ShareProductVo;

import java.util.List;

public interface ShareProductService {
    //添加用户分享商品表
    int insertShareProduct(ShareProduct shareProduct);
    //按分享用户id查询分享商品详情
    List<ShareProductVo> selectShareProductById(Long shareUserId);
}
