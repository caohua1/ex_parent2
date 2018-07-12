package com.ex.controller.merchant_app_controller.productManageController;
import com.ex.service.ProductService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
//（测试成功）
public class MerchantAppProductController {

    @Autowired
    private ProductService productService;


    /**
     * 商家app端，分页查询所有商品(条件查询：商品名称，状态)
     * @param productInfoManageVo
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectProductInfos")
    public JsonView selectProductInfos(ProductInfoManageVo productInfoManageVo, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<ProductInfoManageVo> productInfoManagePageInfo = productService.selectAppProductInfos(productInfoManageVo, pageRequest);
            Integer count = productService.selectCount(productInfoManageVo);
            if(productInfoManagePageInfo!=null && productInfoManagePageInfo.getSize()>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询成功");
                jsonView.setData(productInfoManagePageInfo);
                jsonView.setTodoCount(count);//总数量
            }else{
                jsonView.setMessage("暂无数据");
                jsonView.setCode(JsonView.ERROR);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询失败");
        }
        return jsonView;
    }

}
