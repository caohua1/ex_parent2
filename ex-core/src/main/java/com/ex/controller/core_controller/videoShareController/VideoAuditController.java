package com.ex.controller.core_controller.videoShareController;

import com.ex.entity.MerchantorpersonUploadProduct;
import com.ex.service.MerchantorpersonUploadProductService;
import com.ex.util.DateAndTimeUtil;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 视享审核接口
 */
@RestController
@RequestMapping("/VideoAudit")
public class VideoAuditController {

    @Autowired
    private MerchantorpersonUploadProductService merchantorpersonUploadProductService;

    /**
     * 视享审核（查询）
     * @param page
     * @param id
     * @param merchantId
     * @param describe
     * @param firstDate
     * @param lastDate
     * @param status
     * @return
     */
    @RequestMapping("selectMerchantorpersonUploadProduct")
    public JsonView selectMerchantorpersonUploadProduct(PageRequest page, @RequestParam(required=false)Long id, @RequestParam(required=false)Long merchantId, @RequestParam(required=false)String describe, @RequestParam(required=false)String firstDate, @RequestParam(required=false)String lastDate,@RequestParam(required=false)String status) {
        Map conditionMap = new HashMap<String, Object>();
        Map map = new HashMap<String, Object>();
        JsonView jsonView= new JsonView();
        try {
            if (id != null) {
                conditionMap.put("id", id);
            }
            if (merchantId != null) {
                conditionMap.put("merchantId", merchantId);
            }
            if (describe != null && describe != "") {
                conditionMap.put("describe", describe);
            }
            if (firstDate != null && firstDate != "") {
                conditionMap.put("firstDate", DateAndTimeUtil.convert(firstDate));
            }
            if (lastDate != null && lastDate != "") {
                conditionMap.put("lastDate", DateAndTimeUtil.convert(lastDate));
            }
            if (status != null && status != "") {
                int sta = Integer.parseInt(status);
                conditionMap.put("sta", sta);
            }
            PageInfo<MerchantorpersonUploadProduct> merchantorpersonUploadProductPageInfo = merchantorpersonUploadProductService.selectMerchantorpersonUploadProduct(page, conditionMap);
            map.put("entity",merchantorpersonUploadProductPageInfo);
            map.put("result","访问成功");
            jsonView.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonView;
    }

    /**
     * 视享详情页（审核状态的修改）
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("updateStatus")
    public JsonView updateStatus(Long id,String status){
        Map statusMap = new HashMap<String, Object>();
        Map map = new HashMap<String, Object>();
        JsonView jsonView= new JsonView();
        try{
            if(id!=null&&status!=null&&status!=""){
                statusMap.put("id",id);
                statusMap.put("status",status);
                int i = merchantorpersonUploadProductService.updateStatus(statusMap);
                if(i>0){
                    map.put("entity",i);
                    map.put("result","访问成功");
                    jsonView.setData(map);
                }else {
                    map.put("result", "未修改数据库任何数据");
                    jsonView.setData(map);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonView;
    }
}
