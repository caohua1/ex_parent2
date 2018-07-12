package com.ex.controller.core_controller.productManageController;
import com.ex.entity.ProductClassify;
import com.ex.entity.ProductInfoManage;
import com.ex.entity.ProductPropertySet;
import com.ex.service.ProductService;
import com.ex.util.DateAndTimeUtil;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/coreProduct")
//(已测试，成功)
public class ProductCoreController {
    @Autowired
    private ProductService productService;


    /**
     * 跳转到审核页面
     * @param model
     * @return
     */
    @RequestMapping("/toCoreProductSH")
    public String toCoreProductSH(Model model){
        List<ProductClassify> productClassifies = productService.selectProductClassify(null);
        model.addAttribute("productClassifies",productClassifies);
        return "";
    }

    /**
     * 分页查询所有商品(条件查询：商品名称，分类级别)
     * @param productName
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectCoreProductInfos")
    @ResponseBody
    public JsonView selectProductInfos(String productName,String startTime,String endTime, Long productClassifyId,Integer levelNum, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            if(productName!=null && !productName.equals("")){
                map.put("productName",productName);
            }
            if(startTime!=null && !startTime.equals("")){
                map.put("startTime", DateAndTimeUtil.convert(startTime));
            }
            if(endTime!=null && !endTime.equals("")){
                map.put("endTime",DateAndTimeUtil.convert(endTime));
            }
            if(productClassifyId!=null){
                map.put("productClassifyId",productClassifyId);
            }
            if(levelNum!=null){
                map.put("levelNum",levelNum);
            }
            PageInfo<ProductInfoManageVo> productInfoManageVoPageInfo = productService.selectCoreProductInfos(map, pageRequest);
            Integer count = productService.selectCoreProductInfosCount(map);
            if(productInfoManageVoPageInfo!=null && productInfoManageVoPageInfo.getSize()>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("返回数据成功");
                jsonView.setData(productInfoManageVoPageInfo);
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


    /**
     * 查询商品的详情
     * @param id
     * @return
     */
    @RequestMapping("/selectCoreProductInfoById")
    @ResponseBody
    public JsonView selectProductInfoById(Long id){
        JsonView jsonView = new JsonView();
        try{
            ProductInfoManageVo productInfoManageVo = productService.selectProductInfoById(id);
            if(productInfoManageVo!=null){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询诗句成功");
                jsonView.setData(productInfoManageVo);
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


    /**
     * 修改商品详情（审核修改状态/修改）
     * @param productInfoManage
     * @return
     */
    @RequestMapping("/updateCoreProductInfo")
    @ResponseBody
    public JsonView updateProductInfo(ProductInfoManage productInfoManage, @RequestParam(required=false) List<ProductPropertySet> productPropertySetList){
        JsonView jsonView = new JsonView();
        try{
            productInfoManage.setUpdateTime(new Date());
            Boolean b = productService.updateProductInfo(productInfoManage,productPropertySetList);
            if(b==true){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("修改成功");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("修改失败");
        }
        return jsonView;
    }
}
