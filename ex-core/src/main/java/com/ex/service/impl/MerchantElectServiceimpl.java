package com.ex.service.impl;

import com.ex.dao.MerchantElectDao;
import com.ex.service.MerchantElectService;
import com.ex.util.PageRequest;
import com.ex.vo.MerchantCoreVo;
import com.ex.vo.MerchantElectVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class MerchantElectServiceimpl implements MerchantElectService {

    @Autowired
    private MerchantElectDao merchantElectDao;

    /**
     * 添加互推数据
     * @param termMap
     * @return
     */
    @Override
    public int insertMerchantElect(Map termMap) {
        return merchantElectDao.insertMerchantElect(termMap);
    }

    /**
     * 根据被互推商家id查询待确认状态
     * @param BeMerchantId
     * @return
     */
    @Override
    public PageInfo<MerchantElectVo> selectUnconfirmed(PageRequest page, Long BeMerchantId) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<MerchantElectVo> merchantElectVos = merchantElectDao.selectUnconfirmed(BeMerchantId);
        PageInfo<MerchantElectVo> merchantElectVoPageInfo = new PageInfo<>(merchantElectVos);
        return merchantElectVoPageInfo;
    }

    /**
     * 根据互推商家id查询当前商家所有互推数据
     * @param page
     * @param merchantId
     * @return
     */
    @Override
    public PageInfo<MerchantElectVo> selectElectManage(PageRequest page, Long merchantId) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<MerchantElectVo> ElectManages = merchantElectDao.selectElectManage(merchantId);
        PageInfo<MerchantElectVo> ElectManagePageInfo = new PageInfo<>(ElectManages);
        return ElectManagePageInfo;
    }

    /**
     * 修改商家之间互推关系
     * @return
     */
    @Override
    public int updateMerchantElect(Map termMap) {
        return merchantElectDao.updateMerchantElect(termMap);
    }

    /**
     * 运营后台查询所有互推数据
     * @return
     */
    @Override
    public PageInfo<MerchantCoreVo> selectAllMerchant(PageRequest page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<MerchantCoreVo> merchantCoreVos = merchantElectDao.selectAllMerchant();
        PageInfo<MerchantCoreVo> merchantCoreVoPageInfo = new PageInfo<>(merchantCoreVos);
        return merchantCoreVoPageInfo;
    }
}
