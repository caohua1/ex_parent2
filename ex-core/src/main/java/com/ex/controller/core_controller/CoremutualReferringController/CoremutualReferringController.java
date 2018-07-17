package com.ex.controller.core_controller.CoremutualReferringController;

import com.ex.service.MerchantElectService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.MerchantCoreVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/CoreMutualReferring")
public class CoremutualReferringController {

    @Autowired
    private MerchantElectService merchantElectService;

    /**
     * 运营后台互推
     * @param page
     * @return
     */
    @RequestMapping("selectAllMerchant")
    public JsonView selectAllMerchant(PageRequest page){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<MerchantCoreVo> merchantCoreVoPageInfo = merchantElectService.selectAllMerchant(page);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(merchantCoreVoPageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询失败");
        }
        return jsonView;
    }
    /**
     * 修改商家之间互推关系
     */
    public JsonView updateMerchant(Long merchantId,Long BeMerchantId,int state){
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
