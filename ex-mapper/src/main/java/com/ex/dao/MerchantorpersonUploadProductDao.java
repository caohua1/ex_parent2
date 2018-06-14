package com.ex.dao;

import com.ex.entity.MerchantorpersonUploadProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 视享审核
 */
@Mapper
public interface MerchantorpersonUploadProductDao {


    /**
     * 条件查询（视享审核）
     * @param conditionMap
     * @return
     */
    public List<MerchantorpersonUploadProduct> selectMerchantorpersonUploadProduct(Map conditionMap);

    /**
     * 视享详情页 （状态审核）
     * @param statusMap
     * @return
     */
    public int updateStatus(Map statusMap);

    /**
     * 商家pc端视频上传
     * @param merchantorpersonUploadProduct
     * @return
     */
    public int insertMerchantorpersonUploadProduct(MerchantorpersonUploadProduct merchantorpersonUploadProduct);
}
