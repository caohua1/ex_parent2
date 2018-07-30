package com.ex.controller.user_app_controller.exController;
import com.ex.dao.StoreInfoDao;
import com.ex.entity.ProductClassify;
import com.ex.entity.StoreInfo;
import com.ex.service.AppProductClassifyService;
import com.ex.service.AppStoreInfoService;
import com.ex.service.ExIndexService;
import com.ex.service.UserOrdersService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/apiProduct")
public class ProductClassifyController {
    @Autowired
    private AppProductClassifyService appProductClassifyService;
    @Autowired
    private AppStoreInfoService appStoreInfoService;
    @Autowired
    private UserOrdersService userOrdersService;

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
            } else if(productClassify.getLevelNum()==2 && productClassify.getId()!=null){
                //点击二级分类名称与图标跳转到对应的商家列表页
                PageInfo<StoreInfoVo> pageInfo = appStoreInfoService.selectStoreInfosByProductClassifyId2(productClassify.getId(), pageRequest);
                if(pageInfo!=null && pageInfo.getSize()>0){
                    List<StoreInfoVo> list = pageInfo.getList();
                    for(int i=0;i<list.size();i++){
                        //计算平均评论分数
                        Double merchantDiscussAvg = userOrdersService.selectMerchantDiscussAvg(list.get(i).getMerchantid());
                        list.get(i).setMerchantDiscussAvg(merchantDiscussAvg);//每个商家的平均评分
                        //计算总销售单数
                        Integer orderNums = userOrdersService.selectMerchantOrderNums(list.get(i).getMerchantid());
                        list.get(i).setOrdersNums(orderNums);
                    }
                   pageInfo.setList(list);
                }
                jsonView.setMessage("二级分类，查询商家列表(店铺)");
                jsonView.setData(pageInfo);
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
