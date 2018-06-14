package com.ex.controller.merchant_app_controller.productManageController;
import com.ex.dao.ProductInfoManageDao;
import com.ex.service.ProductService;
import com.ex.util.JsonView;
import com.ex.vo.ProductInfoManageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/api")
@RestController
public class MerchantAppProductController {

    @Autowired
    private ProductService productService;

    /**
     * 商家app端查询所有商品信息
     * @param productInfoManageVo
     * @return
     */
    @RequestMapping("/selectProductInfos")
    public JsonView selectProductInfos(ProductInfoManageVo productInfoManageVo){
        JsonView jsonView = new JsonView();
        try{
            List<ProductInfoManageVo> productInfoManageVos = productService.selectAppProductInfos(productInfoManageVo);
            Integer count = productService.selectCount(productInfoManageVo);
            if(productInfoManageVos!=null && productInfoManageVos.size()>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询数据成功");
                jsonView.setData(productInfoManageVos);
                jsonView.setTodoCount(count);
            }else{
                jsonView.setMessage("暂无数据");
                jsonView.setCode(JsonView.SUCCESS);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询失败");
        }
        return jsonView;
    }
}
