package com.ex.controller.merchant_app_controller.index;
import com.ex.entity.Orders;
import com.ex.service.UserOrdersService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.OrderVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usersOrdersManage")
//首页，客户管理模块
public class UsersManageController {

    @Autowired
    private UserOrdersService userOrdersService;

    /**
     * 商家app首页的客户管理，根据merchantId查询购买过此商家商品的客户的信息（去重，一个用户在此商家有多个订单）(消费金额)，几笔待发货
     * @return
     */
    @RequestMapping("/selectUserByMerchantId")
    public JsonView selectUserByMerchantId(Long merchantId, PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            //1.查询在此商家购买商品的所有的用户信息
            PageInfo<OrderVo> pageInfo = userOrdersService.selectUserByMerchantId(merchantId, pageRequest);
            //去重
            List<OrderVo> orderVoList = pageInfo.getList();
            List<OrderVo> orderVosUser = new ArrayList<>();//所有购买此商家商品的用户（不重复）
            List<Orders> orders = new ArrayList<>();//某用户的订单

            if(orderVoList!=null && orderVoList.size()>0){
                for(int i=0;i<orderVoList.size();i++){
                    int j = 1;
                    if(i>0){
                        if(orderVoList.get(i).getRegistUserId()!=orderVoList.get(i-1).getRegistUserId()){
                            orders = new ArrayList<Orders>();//下一个用户的订单
                            OrderVo orderVo = new OrderVo();//下一个的用户
                            orderVo.setRegistUserId(orderVoList.get(i).getRegistUserId());
                            orderVo.setConsumption(orderVoList.get(i).getConsumption());
                            orderVo.setHeadUrl(orderVoList.get(i).getHeadUrl());
                            orderVo.setShipmentNum(0);
                            orderVo.setNickName(orderVoList.get(i).getNickName());
                            orderVosUser.add(orderVo);
                            for(int k=0;k<orderVosUser.size();k++){
                                //待发货的订单
                                if(orderVosUser.get(k).getRegistUserId()==orderVoList.get(i).getRegistUserId() && (orderVoList.get(i).getStatus()==0 || orderVoList.get(i).getStatus()==2)){
                                    orders.add(orderVoList.get(i)); //把某用户的订单set到list集合中
                                    orderVosUser.get(k).setOrdersList(orders);
                                    orderVosUser.get(k).setShipmentNum(orderVosUser.get(k).getShipmentNum()+1);
                                    orderVosUser.get(k).setConsumption(orderVoList.get(i).getOrderMoney()+orderVosUser.get(k).getConsumption());

                                }
                            }
                        }

                        if(orderVoList.get(i).getRegistUserId()==orderVoList.get(i-1).getRegistUserId()){
                            for(int k=0;k<orderVosUser.size();k++){
                                //待发货的订单
                                if(orderVosUser.get(k).getRegistUserId()==orderVoList.get(i).getRegistUserId() && (orderVoList.get(i).getStatus()==0 || orderVoList.get(i).getStatus()==2)){
                                    orders.add(orderVoList.get(i)); //把某用户的订单set到list集合中
                                    orderVosUser.get(k).setOrdersList(orders);
                                    orderVosUser.get(k).setShipmentNum(orderVosUser.get(k).getShipmentNum()+1);
                                    orderVosUser.get(k).setConsumption(orderVoList.get(i).getOrderMoney()+orderVosUser.get(k).getConsumption());

                                }
                            }
                        }
                    }else{
                        orders = new ArrayList<Orders>();
                        OrderVo orderVo = new OrderVo();
                        orderVo.setRegistUserId(orderVoList.get(i).getRegistUserId());
                        orderVo.setConsumption(orderVoList.get(i).getConsumption());
                        orderVo.setHeadUrl(orderVoList.get(i).getHeadUrl());
                        orderVo.setShipmentNum(1);
                        orderVo.setNickName(orderVoList.get(i).getNickName());
                        orderVosUser.add(orderVo);
                        orders.add(orderVoList.get(i)); //把某用户的订单set到list集合中
                        orderVosUser.get(0).setOrdersList(orders);
                        orderVosUser.get(0).setShipmentNum(orderVosUser.get(0).getShipmentNum()+1);
                        orderVosUser.get(0).setConsumption(orderVoList.get(i).getOrderMoney()+orderVosUser.get(0).getConsumption());
                    }

                }
            }
            pageInfo.setList(orderVosUser);
            //2.查询购买过此商家商品的用户的总数量
            Map map = userOrdersService.selectUserByMerchantIdCount(merchantId);
            Map map1 = new HashMap();
            map1.put("count",map);
            map1.put("pageInfo",pageInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(map1);
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("查询异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }



    //===================================================第二种方式
    /**
     * 商家app首页的客户管理，根据merchantId查询购买过此商家商品的客户的信息（去重，一个用户在此商家有多个订单）(消费金额)，几笔待发货
     * @return
     */
    @RequestMapping("/selectUserByMerchantId2")
    public JsonView selectUserByMerchantId2(Long merchantId,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            PageInfo<OrderVo> pageInfo = userOrdersService.selectUserByMerchantId2(merchantId, pageRequest);
            //查询某用户的累计消费，待发货量
            List<OrderVo> list = pageInfo.getList();
            for(int i=0;i<list.size();i++){
                Map map = new HashMap();
                map.put("registUserId",list.get(i).getRegistUserId());
                map.put("merchantId",merchantId);
                Double consumption = userOrdersService.selectUserMoneyByMerchantId2(map);
                list.get(i).setConsumption(consumption);//累计消费
                Integer shipmentNum = userOrdersService.selectUserOrdersCountByMerchantId2(map);
                list.get(i).setShipmentNum(shipmentNum);//待发货量
            }
            pageInfo.setList(list);
            //查询用户总数
            Integer userCount = userOrdersService.selectUserCountByMerchantId2(merchantId);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(pageInfo);
            jsonView.setTodoCount(userCount);//用户总数
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    /**
     * 查询某用户的代发货的商品详情，（分页查询）
     * @param merchantId
     * @param registUserId
     * @param pageRequest
     * @return
     */
    @RequestMapping("/selectUserOrderInfo2")
    public JsonView selectUserOrderInfo2(Long merchantId,Long registUserId,PageRequest pageRequest){
        JsonView jsonView = new JsonView();
        try{
            Map map = new HashMap();
            map.put("registUserId",registUserId);
            map.put("merchantId",merchantId);
            PageInfo<OrderVo> pageInfo = userOrdersService.selectUserOrdersByMerchantId2(map, pageRequest);
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

}
