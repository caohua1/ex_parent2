package com.ex.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.ex.dao.OrdersDao;
import com.ex.dao.ProductInfoManageDao;
import com.ex.dao.ProductPropertySetDao;
import com.ex.entity.ProductPropertySet;
import com.ex.service.PCOrderService;
import com.ex.util.PageRequest;
import com.ex.vo.OrderVo;
import com.ex.vo.PCOrderVo;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Service(version = "1.1.0")
public class PCOrderServiceImpl implements PCOrderService {

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private ProductInfoManageDao productInfoManageDao;
    @Autowired
    private ProductPropertySetDao productPropertySetDao;


    /**
     * 后台，订单管理，所有订单的信息
     * @param pcOrderVo
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<PCOrderVo> selectAllOrder(PCOrderVo pcOrderVo, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<PCOrderVo> pcOrderVos = ordersDao.selectAllOrder(pcOrderVo);
        PageInfo<PCOrderVo> pcOrderVoPageInfo = new PageInfo<>(pcOrderVos);
        pcOrderVoPageInfo.setSize(pcOrderVos.size());
        return pcOrderVoPageInfo;
    }



    /**
     * 查询分享订单(销售订单)的详情
     * @param id
     * @return
     */
    @Override
    public OrderVo selectShareOrderInfoById(Long id) {
        OrderVo orderVo = ordersDao.selectShareOrderInfoById(id);
        if(orderVo!=null){
            List list = new ArrayList();
            ProductInfoManageVo productInfoManageVo = productInfoManageDao.selectProductInfoById(orderVo.getProductInfoId());
            orderVo.setProductInfoManageVo(productInfoManageVo);
            String[] split = orderVo.getProductPropertyId().split(",");
            for(String s:split){
                list.add(Long.parseLong(s));
            }
            List<ProductPropertySet> productPropertySets = productPropertySetDao.selectSetByOrder(list);
            productInfoManageVo.setProductPropertySetList(productPropertySets);
        }
        return orderVo;
    }
}
