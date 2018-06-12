package com.ex.controller.merchant_pc_controller.productManageController;

import com.ex.entity.ProductClassify;
import com.ex.service.ProductClassifyService;
import com.ex.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//商品管理模块(pc端的接口)
@RequestMapping("/product")
@RestController
public class ProductClassifyController {
    @Autowired
    private ProductClassifyService productClassifyService;

    /**
     * 选择商品分类（根据级别（一级/二级/三级））
     * @return
     */
    @RequestMapping("/selectProductClassify")
    public JsonView selectProductClassify(){
        JsonView jsonView = new JsonView();
        try{
            ProductClassify productClassify = new ProductClassify();
            productClassify.setLevelNum(1);
            List<ProductClassify> productClassifies = productClassifyService.selectProductClassify(productClassify);
            if(productClassifies!=null){
                jsonView.setMessage("返回数据成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(productClassifies);
            }else{
                jsonView.setMessage("暂无数据");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("返回数据失败");
        }
        return jsonView;
    }


}
