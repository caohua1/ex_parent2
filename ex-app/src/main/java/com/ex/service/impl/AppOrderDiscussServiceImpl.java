package com.ex.service.impl;

import com.ex.dao.OrderDiscussDao;
import com.ex.service.AppOrderDiscussService;
import com.ex.util.PageRequest;
import com.ex.vo.OrderDiscussVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class AppOrderDiscussServiceImpl implements AppOrderDiscussService {

    @Autowired
    private OrderDiscussDao orderDiscussDao;

    /**
     * 查询某商家的某商品的评价
     * @param map
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<OrderDiscussVo> selectDiscussByMerchantIdAndProductInfoId(Map map, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<OrderDiscussVo> orderDiscussVos = orderDiscussDao.selectDiscussByMerchantIdAndProductInfoId(map);
        PageInfo<OrderDiscussVo> pageInfo = new PageInfo<>(orderDiscussVos);
        return pageInfo;
    }
}
