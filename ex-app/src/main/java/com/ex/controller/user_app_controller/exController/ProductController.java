package com.ex.controller.user_app_controller.exController;
import com.ex.entity.ProductClassify;
import com.ex.service.AppProductClassifyService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apiProduct")
public class ProductController {
    @Autowired
    private AppProductClassifyService appProductClassifyService;

    /**
     * 查询所有的一级产品分类(levelNum=1)
     * 查询某一级分类下边的二级分类（parentId，levelNum=2）
     * 商家列表页，搜索页，展示三级商品信息(parentId,levelNum=3)
     * @return
     */
    @RequestMapping("/selectProductClassify")
    public JsonView selectProductClassify(ProductClassify productClassify,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            if(productClassify.getLevelNum()==1){
                PageInfo<ProductClassify> productClassifyPageInfo = appProductClassifyService.selectProductClassify(productClassify, pageRequest);
                //默认显示第一个一级分类下边的二级分类
                if(productClassifyPageInfo!=null && productClassifyPageInfo.getList().size()>0){
                    productClassify.setLevelNum(2);
                    productClassify.setParentId(productClassifyPageInfo.getList().get(0).getId());
                    PageInfo<ProductClassify> productClassifyPageInfo1 = appProductClassifyService.selectProductClassify(productClassify, pageRequest);
                    //把第一个一级分类的二级分类set到此一级分类中
                    productClassifyPageInfo.getList().get(0).setProductClassifyList(productClassifyPageInfo1.getList());
                }
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(productClassifyPageInfo);
            }else if(productClassify.getLevelNum()==2){
                //点击二级分类名称与图标跳转到对应的商家列表页
                Map map = new HashMap();
                map.put("productClassifyId",productClassify.getId());
                map.put("levelNum",productClassify.getLevelNum());
                PageInfo<ProductInfoManageVo> productInfoManageVoPageInfo = appProductClassifyService.selectCoreProductInfos(map, pageRequest);
                jsonView.setMessage("查询商品成功");
                jsonView.setData(productInfoManageVoPageInfo);
                jsonView.setCode(JsonView.SUCCESS);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


}
