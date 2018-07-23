package com.ex.dao;

import com.ex.entity.ShareProduct;
import com.ex.vo.ShareProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShareProductDao {
    //添加用户分享商品表
    int insertShareProduct(ShareProduct shareProduct);
    //按分享用户id查询分享商品详情
    List<ShareProductVo> selectShareProductById(Long shareUserId);
}
