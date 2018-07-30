package com.ex.service.impl;
import com.ex.dao.MerchantPersonDataDao;
import com.ex.dao.MerchantTransactionDao;
import com.ex.dao.OrdersDao;
import com.ex.dao.StoreInfoDao;
import com.ex.service.MerchantIndexService;
import com.ex.vo.MerchantPersonDataVo;
import com.ex.vo.StoreInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MerchantIndexServiceImpl implements MerchantIndexService {

    @Autowired
    private MerchantPersonDataDao merchantPersonDataDao;
    @Autowired
    private StoreInfoDao storeInfoDao;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private MerchantTransactionDao merchantTransactionDao;


    /**
     * 商家app，首页信息
     * @param merchantId
     * @return
     */
    @Override
    public Map<String, Object> merchantIndex(Long merchantId) {
        Map map = new HashMap();
        //1.查询商家的个人资料信息
        MerchantPersonDataVo merchantPersonDataVo = merchantPersonDataDao.selectPersonDataByMerchantId(merchantId);
        map.put("merchantPersonDataVo",merchantPersonDataVo);
        //2.可提现金额
        StoreInfoVo storeInfo = new StoreInfoVo();
        storeInfo.setMerchantid(merchantId);
        List<StoreInfoVo> storeInfoVos = storeInfoDao.byConditionsQuery(storeInfo);
        Double merchantStoreYuE = storeInfoVos.get(0).getYuE();
        map.put("merchantStoreYuE",merchantStoreYuE);
        //3.冻结金额(用户下单完成并支付，但未交易完成)
        Double DJMoney = ordersDao.selectMerchantDJMoney(merchantId);
        map.put("DJMoney",DJMoney);
        //4.商家已提现金额
        Map merhantJYMap = new HashMap();
        merhantJYMap.put("type",0);
        merhantJYMap.put("merchantId",merchantId);
        Double merchantTXMoney = merchantTransactionDao.selectJYMoney(merhantJYMap);
        map.put("merchantTXMoney",merchantTXMoney);
        //5.今日浏览量（店铺）

        //6.总客户量
        Integer userNum = ordersDao.selectUserNum(merchantId);
        map.put("userNum",userNum);
        //7.七日的订单量
        Integer orderNumByIn7 = ordersDao.selectOrderNumsIn7(merchantId);
        map.put("orderNumByIn7",orderNumByIn7);
        return map;
    }
}
