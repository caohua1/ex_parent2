package com.ex.controller.user_app_controller.exController;

import com.ex.entity.IndexAdvertising;
import com.ex.entity.ProductClassify;
import com.ex.entity.StoreInfo;
import com.ex.service.ExIndexService;
import com.ex.service.UserOrdersService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.ProductInfoManageVo;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exIndex")
public class ExIndexController {

    @Autowired
    private ExIndexService exIndexService;
    @Autowired
    private UserOrdersService userOrdersService;



    /**
     * 广告轮播图
     * @return
     */
    @RequestMapping("/selectIndexAdvertising")
    public JsonView selectIndexAdvertising(){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            map.put("type",0);//banner图
            List<IndexAdvertising> indexAdvertisings = exIndexService.selectAdvertising(map);
            if(indexAdvertisings!=null && indexAdvertisings.size()>0){
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(indexAdvertisings);
            }else{
                jsonView.setMessage("暂无数据");
            }

        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 2的分享（广告图片）
     * @return
     */
    @RequestMapping("/selectIndexAdvertising2")
    public JsonView selectIndexAdvertising2(){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            map.put("type",2);//首页广告（2的分享）
            List<IndexAdvertising> indexAdvertisings = exIndexService.selectAdvertising(map);
            if(indexAdvertisings!=null && indexAdvertisings.size()>0){
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(indexAdvertisings);
            }else{
                jsonView.setMessage("暂无数据");
            }

        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


    /**
     * 用户app端，二享模块(首页)，查询所有的一级商品分类
     * @param productClassify（levelNum=1）
     * @return
     */
    @RequestMapping("/selectProductClassify")
    public JsonView selectProductClassify(ProductClassify productClassify,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<ProductClassify> pageInfo = exIndexService.selectProductClassify(productClassify, pageRequest);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }



    /**
     * 通过一级商品分类查询所有的商家列表，跳转到商家店铺列表
     * @param productClassifyId
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectMerchants")
    public JsonView selectMerchants(Long productClassifyId, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<StoreInfoVo> pageInfo = exIndexService.selectStoreInfosByProductClassifyId1(productClassifyId, pageRequest);
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
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }



    /**
     * 推荐商品
     * @param productInfoManageVo(STJStatus = 1)
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectProduct_TJ")
    public JsonView selectProduct_TJ(ProductInfoManageVo productInfoManageVo,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<ProductInfoManageVo> pageInfo = exIndexService.selectProductInfos(productInfoManageVo, pageRequest);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }



    /**
     * 推荐商家
     * @param storeInfo(STJStatus = 1)
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectStore_TJ")
    public JsonView selectStore_TJ(StoreInfoVo storeInfo,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<StoreInfoVo> storeInfoPageInfo = exIndexService.byConditionsQuery(storeInfo, pageRequest);
            jsonView.setMessage("查询成功");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(storeInfoPageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }


    /**
     * 搜索，按照商家名称模糊查询,进入商家列表页
     * @param storeName
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectStoreByStoreName")
    public JsonView selectStoreByStoreName(String storeName,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<StoreInfoVo> pageInfo = exIndexService.selectStoreByStoreName(storeName, pageRequest);
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
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

}
