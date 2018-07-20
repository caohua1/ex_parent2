package com.ex.controller.user_app_controller.exController;
import com.ex.dao.StoreInfoDao;
import com.ex.entity.AppointmentOrder;
import com.ex.entity.ProductClassify;
import com.ex.entity.StoreInfo;
import com.ex.service.*;
import com.ex.util.DateAndTimeUtil;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.util.UUIDUtil;
import com.ex.vo.OrderDiscussVo;
import com.ex.vo.ProductInfoManageVo;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/merchantStore")
//商家店铺、预订和评价(已测试，成功)
public class MerchantStoreController {

    @Autowired
    private AppointmentOrder1Service appointmentOrderService;
    @Autowired
    private AppProductClassifyService appProductClassifyService;
    @Autowired
    private StoreInfoDao storeInfoDao;
    @Autowired
    private AppOrderDiscussService appOrderDiscussService;
    @Autowired
    private AppStoreInfoService appStoreInfoService;
    @Autowired
    private UserOrdersService userOrdersService;



    /**
     * 1.商家店铺，点击某个商家进入某商家店（包括此商家的商品,分页查询）铺详情页
     * 按照分类查询此商店的商品
     * @param storeInfo（id）
     * @return
     */
    @RequestMapping("/selectStoreInfoById")
    public JsonView selectStoreInfoById(StoreInfo storeInfo,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            int orderNum = 0;
            Map map = new HashMap();
            Map map1 = new HashMap();
            //1.查询此商家的店铺信息
            List<StoreInfo> storeInfos = storeInfoDao.byConditionsQuery(storeInfo);
            map.put("storeInfo",storeInfos.get(0));
            //2.查询此商家的商品
            if(storeInfos!=null && storeInfos.size()>0){
                map1.put("merchantId",storeInfos.get(0).getMerchantid());
                List<ProductInfoManageVo> productInfoManageVos = appProductClassifyService.selectProductsByMerchantId2(map1);
                //计算店铺的销售量
                if(productInfoManageVos!=null && productInfoManageVos.size()>0){
                    for(int i=0;i<productInfoManageVos.size();i++){
                        if(productInfoManageVos.get(i).getSaleOrderNum()!=null){
                            orderNum += productInfoManageVos.get(i).getSaleOrderNum();
                        }
                    }
                }
                PageInfo<ProductInfoManageVo> productInfoManageVosPageInfo = appProductClassifyService.selectProductsByMerchantId(map,pageRequest);
                map.put("productInfoManageVosPageInfo",productInfoManageVosPageInfo);
            }else{
                jsonView.setMessage("数据为空");
            }
            jsonView.setMessage("查询此店铺的信息成功");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(map);
            jsonView.setTodoCount(orderNum);//销售总量
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    /**
     * 查询三级分类，分页查询
     * @param pageRequest
     * @param storeId 商家店铺id
     * @return
     */
    @RequestMapping("/selectProductClassify")
    public JsonView selectProductClassify(PageRequest pageRequest,Long storeId){
        JsonView jsonView = new JsonView();
        try{
            //3.查询三级分类
            Map map = new HashMap();
            map.put("storeId",storeId);
            PageInfo<ProductClassify> productClassifyPageInfo = appProductClassifyService.selectProductClassifyByStoreId(storeId, pageRequest);
            jsonView.setMessage("查询三级分类");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(productClassifyPageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }
    /**
     * 2.商家店铺，分类查询此店铺的商品（分页查询）
     * 按照分类查询此商店的商品
     * @param merchantId
     * @param productClassifyId
     * @return
     */
    @RequestMapping("/selectStoreProductsInfo")
    public JsonView selectStoreProductsInfo(Long merchantId,Long productClassifyId,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map1 = new HashMap();
            //查询此商家的商品
            map1.put("merchantId",merchantId);
            map1.put("productClassifyId",productClassifyId);
            PageInfo<ProductInfoManageVo> pageInfo = appProductClassifyService.selectProductsByMerchantId(map1,pageRequest);
            jsonView.setMessage("查询此商家的商品成功");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);

        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询成功");
        }
        return jsonView;
    }


    /**
     * 根据ids查询所有选择的商品的价格
     * @param ids（id：单价_数量）
     * @return
     */
    @RequestMapping("/selectProductPrice")
    public JsonView selectProductPrice(String ids){
        JsonView jsonView = new JsonView();
        try{
            double prices = appointmentOrderService.selectProductPrice(ids);
            jsonView.setMessage("查询成功");
            jsonView.setData(prices);
            jsonView.setCode(JsonView.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询失败");
        }
        return jsonView;
    }

    /**
     * 用户，预订商品
     * registUserId,merchantId 商家id，productInfoIds商品ids,registUsername用户账号,contactsName联系人,contactsPhone联系电话,
     peopleNum预定人数,orderNum预定编号,merchantName商家名称(店铺名称),productName产品名称,appointmentMoney金额,YDTime时间,
     createTime,remark备注,payWay支付方式,payStatus支付状态
     * @param appointmentOrder
     * @return
     */
    @RequestMapping("/insertAppointmentOrder")
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder,String YDTime){
        try{
            appointmentOrder.setOrderNum(UUIDUtil.getOrderIdByUUId());
            appointmentOrder.setCreateTime(new Date());
            appointmentOrder.setAppointmentTime(DateAndTimeUtil.convert(YDTime));
            JsonView jsonView = appointmentOrderService.insertAppointmentOrder(appointmentOrder);
            return jsonView;
        }catch(Exception e){
            e.printStackTrace();
        }
        return JsonView.fail("预订失败");
    }

    /**
     * 查询某商家的所有商品的评价
     * @param merchantId
     * @param registUserId
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectDiscussByMerchantIdAndProductInfoId")
    public JsonView selectDiscussByMerchantIdAndProductInfoId(Long merchantId,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            map.put("merchantId",merchantId);
            PageInfo<OrderDiscussVo> pageInfo = appOrderDiscussService.selectDiscussByMerchantIdAndProductInfoId(map, pageRequest);
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
     * 点击商品图片与名称，跳转到商品详情页（商品详情，商品评价merchantId，productInfoId）
     * @param id
     * @return
     */
    @RequestMapping("/selectProductInfo")
    public JsonView selectProductInfo(Long id){
        JsonView jsonView = new JsonView();
        try{
            ProductInfoManageVo productInfoManageVo = appProductClassifyService.selectProductInfoById(id);
            if(productInfoManageVo.getSXJStatus()!=null&&productInfoManageVo.getSXJStatus()==0){
                jsonView.setMessage("对不起，您查看的商品已经下架");
                jsonView.setData(productInfoManageVo);
            }else{
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(productInfoManageVo);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 查看某商品的评论
     * @param ProductInfoId
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectDiscussByProductInfoId")
    public JsonView selectDiscussByProductInfoId(Long productInfoId,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            map.put("productInfoId",productInfoId);
            PageInfo<OrderDiscussVo> pageInfo = appOrderDiscussService.selectDiscussByMerchantIdAndProductInfoId(map, pageRequest);
            jsonView.setMessage("查询成功");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }


    /**
     * 商家列表页/搜索结果页，搜索功能（商家名称，地理位置，分类，销量最高，综合评价）
     * @param storename 按商家名称（店铺名称）搜索
     * @param productClassifyid 按二级分类搜索商家列表
     * @param isOrderNum ===1 按销量排序
     * @param isDiscussAvg ===1 按综合排名排序
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectMerchantsByParam")
    public JsonView selectMerchantsByParam(String storename,Long productClassifyid,Integer isOrderNum,Integer isDiscussAvg,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            if(storename!=null && !("").equals(storename)){
                map.put("storename",storename);
            }
            if(productClassifyid!=null){
                map.put("productClassifyid",productClassifyid);
            }
            PageInfo<StoreInfoVo> pageInfo = appStoreInfoService.selectMerchantsByParam(map, pageRequest);
            if(pageInfo!=null && pageInfo.getSize()>0){
                List<StoreInfoVo> list = pageInfo.getList();
                for(int i=0;i<list.size();i++){
                    //计算平均评论分数
                    Double merchantDiscussAvg = userOrdersService.selectMerchantDiscussAvg(list.get(i).getMerchantid());
                    if(merchantDiscussAvg==null){
                        list.get(i).setMerchantDiscussAvg(0.0);
                    }else{
                        list.get(i).setMerchantDiscussAvg(merchantDiscussAvg);//每个商家的平均评分
                    }
                    //计算总销售单数(包括分享订单)
                    Integer orderNums = userOrdersService.selectMerchantOrderNums(list.get(i).getMerchantid());
                    if(orderNums==null){
                        list.get(i).setOrdersNums(0);
                    }else{
                        list.get(i).setOrdersNums(orderNums);
                    }
                }
                pageInfo.setList(list);
            }
            //如果按销量排序
            if(isOrderNum!=null){
                pageInfo.getList().sort(new Comparator<StoreInfoVo>() {//Comparator 比较器. 需要实现比较方法
                    @Override
                    public int compare(StoreInfoVo o1, StoreInfoVo o2) {
                        return o2.getOrdersNums()-o1.getOrdersNums();//从大到小
                    }
                });
            }
            //如果按综合评价排序
            if(isDiscussAvg!=null){
                pageInfo.getList().sort(new Comparator<StoreInfoVo>() {//Comparator 比较器. 需要实现比较方法
                    @Override
                    public int compare(StoreInfoVo o1, StoreInfoVo o2) {
                        return (int) (o2.getMerchantDiscussAvg()-o1.getMerchantDiscussAvg());//从大到小
                    }
                });
            }
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("返回数据成功");
            jsonView.setData(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

}
