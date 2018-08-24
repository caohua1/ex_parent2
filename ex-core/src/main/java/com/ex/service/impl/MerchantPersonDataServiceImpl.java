package com.ex.service.impl;

import com.ex.dao.MerchantPersonDataDao;
import com.ex.dao.OrdersDao;
import com.ex.entity.MerchantTransaction;
import com.ex.service.MerchantPersonDataService;
import com.ex.util.PageRequest;
import com.ex.vo.MerchantMoneyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MerchantPersonDataServiceImpl implements MerchantPersonDataService {

    @Autowired
    private MerchantPersonDataDao merchantPersonDataDao;
    @Autowired
    private OrdersDao ordersDao;

    /**
     * 商家的账户管理
     * @param map
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<MerchantMoneyVo> selectMerchantYuE(Map map, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<MerchantMoneyVo> merchantMoneyVos = merchantPersonDataDao.selectMerchantYuE(map);
        if(merchantMoneyVos!=null && merchantMoneyVos.size()>0){
            for(int i=0;i<merchantMoneyVos.size();i++){
                Double tqMoney = merchantPersonDataDao.selectTQMoney(merchantMoneyVos.get(i).getMerchantId());
                //3.冻结金额(保护期金额)(用户下单完成并支付，但未交易完成)
                Double DJMoney = ordersDao.selectMerchantDJMoney(merchantMoneyVos.get(i).getMerchantId());
                //提取中的金额
                if(tqMoney!=null){
                    merchantMoneyVos.get(i).setTQMoney(tqMoney);
                }else{
                    merchantMoneyVos.get(i).setTQMoney(0.0);
                }
                //商家可用余额
                if(merchantMoneyVos.get(i).getYuE()==null){
                    merchantMoneyVos.get(i).setYuE(0.0);
                }
                //商家冻结金额（保护期的金额）
                if(DJMoney!=null){
                    merchantMoneyVos.get(i).setDJMoney(DJMoney);
                }else{
                    merchantMoneyVos.get(i).setYuE(0.0);
                }

            }
        }
        PageInfo<MerchantMoneyVo> pageInfo = new PageInfo<>(merchantMoneyVos);
        pageInfo.setSize(merchantMoneyVos.size());
        return pageInfo;
    }

    /**
     * 商家账户明细
     * @param map
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<MerchantTransaction> selectMerchantTransaction(Map map, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<MerchantTransaction> merchantMoneyVos = merchantPersonDataDao.selectMerchantTransaction(map);
        PageInfo<MerchantTransaction> pageInfo = new PageInfo<>(merchantMoneyVos);
        return pageInfo;
    }
}
