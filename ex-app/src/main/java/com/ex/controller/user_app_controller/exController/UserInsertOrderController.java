package com.ex.controller.user_app_controller.exController;
import com.ex.dao.OrdersDao;
import com.ex.dao.ProductInfoManageDao;
import com.ex.entity.*;
import com.ex.service.UserOrdersService;
import com.ex.util.JsonView;
import com.ex.vo.ProductInfoManageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/userInsertOrder")
public class UserInsertOrderController {

    @Autowired
    private UserOrdersService userOrdersService;
    @Autowired
    private ProductInfoManageDao productInfoManageDao;
    @Autowired
    private OrdersDao ordersDao;


    /**
     * 用户下单，选择支付方式，先支付（从数据库重新查询支付金额），添加oders表，再添加user_order表
     * @param orders
     * @param userOrder(传参：registUserId)
     * @param shareUserId (分享者id，是否是其他用户分享的订单)
     * @param shareUsername 分享着的用户名
     * @param buyUsername 购买者的用户名
     * @return
     */
    @RequestMapping("/userInsertOrder")
    @ResponseBody
    public JsonView userInsertOrder(Orders orders, UserOrder userOrder,Long shareUserId,String shareUsername,String buyUsername){
        JsonView jsonView = new JsonView();
        try{
            if(orders!=null && orders.getProductInfoId()!=null){
                //1.查询价格
                ProductInfoManageVo productInfoManageVo = productInfoManageDao.selectProductInfoById(orders.getProductInfoId());
                //2.先判断是不是代理商（agent_merchant），是代理按照代理价格计算，不是代理按零售价计算（registUserId和merchamtId查询）
                Map map = new HashMap();
                map.put("registUserId",userOrder.getRegistUserId());
                map.put("merchantId",productInfoManageVo.getMerchantId());
                AgentMerchant agentMerchant = ordersDao.selectMerchantAgent(map);

                //3.再计算价格
                if(agentMerchant!=null){//是代理，按代理价计算
                   Double orderMoney = productInfoManageVo.getAgentPrice()*orders.getProductNum();
                   orders.setOrderMoney(orderMoney);
                }else{
                    Double orderMoney = productInfoManageVo.getResalePrice()*orders.getProductNum();
                    orders.setOrderMoney(orderMoney);
                }

                //4.提交订单
                Boolean b = userOrdersService.insertOrders(orders, userOrder,shareUserId,shareUsername,buyUsername,productInfoManageVo);
                if(b==true){
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("提交订单成功");
                }else{
                    jsonView.setCode(JsonView.ERROR);
                    jsonView.setMessage("提交订单失败");
                }
            }else{
                jsonView.setMessage("数据为空");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("提交订单异常");
        }
        return jsonView;
    }


    /**
     *
     * @param orderId
     * @param payWay 支付方式（0微信支付 1支付宝支付）
     * @return
     */
    @RequestMapping("/payOrder")
    public String payOrder(Long orderId,Integer payWay){

        //1.根据订单id，查询价格
        Orders orders = userOrdersService.selectOrdersById(orderId);
        Double orderMoney = orders.getOrderMoney();//要支付的金额

        //2.再支付（0微信支付 1支付宝支付）

        //3.支付成功,修改订单表支付状态
        Map map = new HashMap();
        map.put("updateTime",new Date());
        map.put("payTime",new Date());
        map.put("id",orderId);
        map.put("payWay",payWay);
        //如果支付成功
        map.put("payStatus",1);
        //如果支付失败
       // map.put("payStatus",2);
        int i = userOrdersService.updateOrdersStatusById(map);
        if(i>0){
            return "修改成功";
        }else{
            return "操作失败";
        }
    }

}
