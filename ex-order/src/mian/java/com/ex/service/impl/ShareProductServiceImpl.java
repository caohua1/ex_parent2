package com.ex.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.ShareProductDao;
import com.ex.entity.ShareProduct;
import com.ex.service.ShareProductService;
import com.ex.vo.ShareProductVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class ShareProductServiceImpl implements ShareProductService {

    @Autowired
    private ShareProductDao shareProductDao;

    @Override
    public int insertShareProduct(ShareProduct shareProduct) {
        shareProduct.setCreateTime(new Date());
        return shareProductDao.insertShareProduct(shareProduct);
    }

    @Override
    public List<ShareProductVo> selectShareProductById(Long shareUserId) {
        return shareProductDao.selectShareProductById(shareUserId);
    }
}
