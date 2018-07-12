package com.ex.service;
import com.ex.util.PageRequest;
import com.ex.vo.OrderDiscussVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface AppOrderDiscussService {

    public PageInfo<OrderDiscussVo> selectDiscussByMerchantIdAndProductInfoId(Map map, PageRequest pageRequest);
}
