package com.ex.controller.user_app_controller.orderController;

import com.ex.entity.ShareOrder;
import com.ex.entity.UserOrder;
import com.ex.service.ShareOrderService;
import com.ex.service.UserAppOrderService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/order")
public class UserOrderController {

    @Autowired
    private UserAppOrderService userAppOrderService;
    @Autowired
    private ShareOrderService shareOrderService;

    /**
     * 按用户ID查询用户所有的订单信息
     * @param registUserId 用户ID
     * @param page 分页条件
     * @return
     */
    @RequestMapping("/selectUserOrderByid")
    public JsonView selectUserOrderByid(Long registUserId, PageRequest page){
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            List<UserOrder> userOrders = userAppOrderService.selectUserOrderByid(registUserId);
            PageInfo<UserOrder> pageInfo = new PageInfo<>(userOrders);
            jsonView.setTodoCount(userOrders.size());
            jsonView.setMessage("查询数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * TODO 作废
     * 按用户ID查询用户所有的收入订单信息
     * @param shareUserId 用户ID
     * @param page 分页条件
     * @return
     */
//    @RequestMapping("/selectShareOrderByShareUserIdAll")
//    public JsonView selectShareOrderByShareUserIdAll(Long shareUserId, PageRequest page){
//        JsonView jsonView = new JsonView();
//        try {
//            PageHelper.startPage(page.getPageNum(),page.getPageSize());
//            List<ShareOrder> shareOrders = shareOrderService.selectShareOrderByShareUserIdAll(shareUserId);
//            PageInfo<ShareOrder> pageInfo = new PageInfo<>(shareOrders);
//            jsonView.setTodoCount(pageInfo.getSize());
//            jsonView.setMessage("查询数据成功!");
//            jsonView.setCode(JsonView.SUCCESS);
//            jsonView.setData(pageInfo);
//        }catch (Exception e){
//            e.printStackTrace();
//            jsonView.setMessage("请求失败!");
//            jsonView.setCode(JsonView.EXPIRED);
//        }
//        return jsonView;
//    }

    /**
     * TODO 作废
     * 按用户ID查询用户所有的支出订单信息
     * @param registUserId 用户ID
     * @param page 分页条件
     * @return
     */
//    @RequestMapping("/selectUserOrderByIdAndStatus")
//    public JsonView selectUserOrderByIdAndStatus(Long registUserId, PageRequest page){
//        JsonView jsonView = new JsonView();
//        try {
//            PageHelper.startPage(page.getPageNum(),page.getPageSize());
//            List<UserOrder> userOrders = userAppOrderService.selectUserOrderByIdAndStatus(registUserId);
//            PageInfo<UserOrder> pageInfo = new PageInfo<>(userOrders);
//            jsonView.setTodoCount(pageInfo.getSize());
//            jsonView.setMessage("查询数据成功!");
//            jsonView.setCode(JsonView.SUCCESS);
//            jsonView.setData(pageInfo);
//        }catch (Exception e){
//            e.printStackTrace();
//            jsonView.setMessage("请求失败!");
//            jsonView.setCode(JsonView.EXPIRED);
//        }
//        return jsonView;
//    }

    /**
     * 查询所有订单信息
     * @param page 分页数据
     * @return
     */
    @RequestMapping("/selectUserOrderAll")
    public JsonView selectUserOrderAll(PageRequest page){
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            List<UserOrder> userOrders = userAppOrderService.selectUserOrderAll();
            PageInfo<UserOrder> pageInfo = new PageInfo<>(userOrders);
            jsonView.setTodoCount(userOrders.size());
            jsonView.setMessage("查询数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 修改订单状态
     * @param status 订单状态
     * @param userOrderId 用户ID
     * @param orderId 订单ID
     * @return
     */
    @RequestMapping("/updateUserOrder")
    public JsonView updateUserOrder(Integer status, Long userOrderId,Long orderId){
        JsonView jsonView = new JsonView();
        try {
            userAppOrderService.updateUserOrder(status, userOrderId, orderId);
            jsonView.setMessage("请求成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 添加订单信息===暂时不可用
     * @param userOrder
     * @return
     */
    @RequestMapping("/insertUserOrder")
    public JsonView insertUserOrder(UserOrder userOrder){
        JsonView jsonView = new JsonView();
        try {
            userOrder.setStatus(1);
            userAppOrderService.insertUserOrder(userOrder);
            jsonView.setMessage("请求成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(1);
            jsonView.setData(userOrder);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}
