package com.ex.controller.user_app_controller.exController;

import com.ex.dao.StoreInfoDao;
import com.ex.entity.AppointmentOrder;
import com.ex.entity.StoreInfo;
import com.ex.service.AppProductClassifyService;
import com.ex.service.AppointmentOrder1Service;
import com.ex.util.JsonView;
import com.ex.util.UUIDUtil;
import com.ex.vo.ProductInfoManageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    /**
     * 3.商家店铺，点击某个商家进入某商家店（包括此商家的商品）铺详情页
     * @param storeInfo（id）
     * @return
     */
    @RequestMapping("/selectStoreInfoById")
    public JsonView selectStoreInfoById(StoreInfo storeInfo){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            //1.查询此商家的店铺信息
            List<StoreInfo> storeInfos = storeInfoDao.byConditionsQuery(storeInfo);
            //2.查询此商家的商品
            if(storeInfos!=null && storeInfos.size()>0){
                map.put("storeInfo",storeInfos.get(0));
                List<ProductInfoManageVo> productInfoManageVos = appProductClassifyService.selectProductsByMerchantId(storeInfos.get(0).getMerchantid());
                map.put("productInfoManageVos",productInfoManageVos);
                jsonView.setMessage("查询此商家的商品成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(map);
            }else{
                jsonView.setMessage("数据为空");
            }
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
     * registUserId,productInfoIds商品ids,registUsername用户账号,contactsName联系人,contactsPhone联系电话,
     peopleNum预定人数,orderNum预定编号,merchantName商家名称,productName产品名称,appointmentMoney金额,appointmentTime时间,
     createTime,remark备注,payWay支付方式,payStatus支付状态
     * @param appointmentOrder
     * @return
     */
    @RequestMapping("/insertAppointmentOrder")
    public JsonView insertAppointmentOrder(AppointmentOrder appointmentOrder){
        try{
            appointmentOrder.setOrderNum(UUIDUtil.getOrderIdByUUId());
            System.out.println(UUIDUtil.getOrderIdByUUId());
            appointmentOrder.setCreateTime(new Date());
            JsonView jsonView = appointmentOrderService.insertAppointmentOrder(appointmentOrder);
            return jsonView;
        }catch(Exception e){
            e.printStackTrace();
        }
        return JsonView.fail("预订失败");
    }

}
