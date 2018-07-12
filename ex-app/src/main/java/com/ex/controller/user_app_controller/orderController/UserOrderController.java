package com.ex.controller.user_app_controller.orderController;

import com.ex.entity.UserOrder;
import com.ex.service.UserAppOrderService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/order")
public class UserOrderController {

    @Autowired
    private UserAppOrderService userAppOrderService;

    @RequestMapping("/selectUserOrderByid")
    public JsonView selectUserOrderByid(long registUserId, PageRequest page){
        JsonView jsonView = new JsonView();
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("registUserId",registUserId);
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            List<UserOrder> userOrders = userAppOrderService.selectUserOrderByid(map);
            PageInfo<UserOrder> pageInfo = new PageInfo<>(userOrders);
            jsonView.setTodoCount(pageInfo.getSize());
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

    public JsonView selectUserOrderAll(UserOrder userOrder){
        JsonView jsonView = new JsonView();
        try {

        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    public JsonView updateUserOrder(UserOrder userOrder){
        JsonView jsonView = new JsonView();
        try {

        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    public JsonView insertUserOrder(UserOrder userOrder){
        JsonView jsonView = new JsonView();
        try {

        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}
