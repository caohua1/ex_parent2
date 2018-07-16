package com.ex.controller.merchant_app_controller.mutualReferringManageController;

import com.ex.service.MerchantElectService;
import com.ex.service.MerchantRegistService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.MerchantElectVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app 、端商家互推类
 */
@RestController
@RequestMapping("/mutualReferringController")
public class mutualReferringController {

    @Autowired
    private MerchantRegistService MerchantRegistService;

    @Autowired
    private MerchantElectService merchantElectService;

    /**
     * 互推设置接口
     * @return
     */
    @RequestMapping("ElectSet")
    public JsonView ElectSet(Long merchantId,String username,Double commissionRate){
        JsonView jsonView = new JsonView();
        Map termMap = new HashMap<String, Object>();
        try{
            Long BeMerchantId = MerchantRegistService.selectMutualReferrringById(username);
            if(merchantId!=null){
                termMap.put("merchantId",merchantId);
            }if(username!=null&&username!=""){
                termMap.put("BeMerchantId",BeMerchantId);
            }if(commissionRate!=null){
                termMap.put("commissionRate",commissionRate);
            }
            termMap.put("electMerchantStatus",0);
            termMap.put("BeElectMerchantStatus",0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String format = simpleDateFormat.format(date);
            Date parse = simpleDateFormat.parse(format);
            termMap.put("createTime",parse);
            int i = merchantElectService.insertMerchantElect(termMap);
            if(i>0){
                jsonView.setMessage("添加数据成功");
            }else {
                jsonView.setMessage("添加数据失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }

    /**
     * 互推确认接口
     * @param BeMerchantId
     * @return
     */
    @RequestMapping("mutualReferringAffirm")
    public JsonView mutualReferringAffirm(PageRequest page, Long BeMerchantId){
        JsonView jsonView = new JsonView();
        try{
           if(BeMerchantId!=null){
               PageInfo<MerchantElectVo> merchantElectVoPageInfo = merchantElectService.selectUnconfirmed(page, BeMerchantId);
               jsonView.setCode(JsonView.SUCCESS);
               jsonView.setMessage("查询成功");
               jsonView.setData(merchantElectVoPageInfo);
           }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 互推管理
     */
    @RequestMapping("selectElectManage")
    public JsonView selectElectManage(PageRequest page, Long merchantId){
        JsonView jsonView = new JsonView();
        try{
            if(merchantId!=null){
                PageInfo<MerchantElectVo> ElectManagePageInfo = merchantElectService.selectElectManage(page, merchantId);
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(ElectManagePageInfo);
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 修改商家之间互推关系
     */
    @RequestMapping("updateMerchantElect")
    public JsonView updateMerchantElect(Long merchantId,Long BeMerchantId,int state ){
        JsonView jsonView = new JsonView();
        Map termMap = new HashMap<String, Object>();
        try{
            if(merchantId!=null){
                termMap.put("merchantId",merchantId);
              if(BeMerchantId!=null){
                  termMap.put("BeMerchantId",BeMerchantId);
                  termMap.put("state",state);
                  int i = merchantElectService.updateMerchantElect(termMap);
                  if(i>0){
                      jsonView.setCode(JsonView.SUCCESS);
                      jsonView.setMessage("修改成功");
                  }else {
                      jsonView.setCode(JsonView.SUCCESS);
                      jsonView.setMessage("修改失败");
                  }
              }
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }
}
