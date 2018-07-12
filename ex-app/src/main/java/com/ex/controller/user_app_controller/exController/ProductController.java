package com.ex.controller.user_app_controller.exController;
import com.ex.dao.StoreInfoDao;
import com.ex.entity.ProductClassify;
import com.ex.entity.StoreInfo;
import com.ex.service.AppProductClassifyService;
import com.ex.service.AppStoreInfoService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/apiProduct")
public class ProductController {
    @Autowired
    private AppProductClassifyService appProductClassifyService;
    @Autowired
    private AppStoreInfoService appStoreInfoService;

    /**
     * 1.分类，查询所有的一级产品分类(levelNum=1)
     * 查询某一级分类下边的二级分类（parentId(一级分类的id)，levelNum=2）
     * 2.商家列表页，搜索页，展示商家列表(id)
     * @return
     */
    @RequestMapping("/selectProductClassify")
    public JsonView selectProductClassify(ProductClassify productClassify,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            if(productClassify.getLevelNum()==1 && productClassify.getParentId()==null){
                PageInfo<ProductClassify> productClassifyPageInfo = appProductClassifyService.selectProductClassify(productClassify, pageRequest);
                //默认显示第一个一级分类下边的二级分类
                if(productClassifyPageInfo!=null && productClassifyPageInfo.getList().size()>0){
                    productClassify.setLevelNum(2);
                    productClassify.setParentId(productClassifyPageInfo.getList().get(0).getId());
                    PageInfo<ProductClassify> productClassifyPageInfo1 = appProductClassifyService.selectProductClassify(productClassify, pageRequest);
                    //把第一个一级分类的二级分类set到此一级分类中
                    productClassifyPageInfo.getList().get(0).setProductClassifyList(productClassifyPageInfo1.getList());
                }
                jsonView.setMessage("查询一级分类成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(productClassifyPageInfo);
            }else if(productClassify.getLevelNum()==2 && productClassify.getParentId()!=null){
                PageInfo<ProductClassify> productClassifyPageInfo = appProductClassifyService.selectProductClassify(productClassify, pageRequest);
                jsonView.setMessage("查询某一级分类下的二级分类成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(productClassifyPageInfo);
            } else if(productClassify.getLevelNum()==2){
                //点击二级分类名称与图标跳转到对应的商家列表页
                StoreInfo storeInfo = new StoreInfo();
                storeInfo.setProductclassifyid(productClassify.getId());
                PageInfo<StoreInfo> storeInfoPageInfo = appStoreInfoService.byConditionsQuery(pageRequest, storeInfo);
                jsonView.setMessage("二级分类，查询商家列表(店铺)");
                jsonView.setData(storeInfoPageInfo);
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
