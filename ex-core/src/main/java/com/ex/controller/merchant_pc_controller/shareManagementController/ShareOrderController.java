package com.ex.controller.merchant_pc_controller.shareManagementController;

import com.ex.entity.ShareOrder;
import com.ex.entity.ShareOrderInfo;
import com.ex.service.ShareOrderService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shareOrderPC")
public class ShareOrderController {

    @Autowired
    private ShareOrderService shareOrderService;

    @RequestMapping("/selectShareOrderAll")
    public JsonView selectShareOrderAll(ShareOrder shareOrder, PageRequest page){
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(),page.getPageSize());
            List<ShareOrder> shareOrders = shareOrderService.selectShareOrderAll(shareOrder,page);
            PageInfo<ShareOrder> pageInfo = new PageInfo<>(shareOrders);
            jsonView.setTodoCount(pageInfo.getSize());
            jsonView.setMessage("查询数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.EXPIRED);
            jsonView.setMessage("请求失败!");
        }
        return jsonView;
    }

    @RequestMapping("/selectShareOrderById")
    public JsonView selectShareOrderById(Long id){
        JsonView jsonView = new JsonView();
        try {
            ShareOrder shareOrder = shareOrderService.selectShareOrderById(id);
            jsonView.setTodoCount(1);
            jsonView.setMessage("查询数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(shareOrder);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.EXPIRED);
            jsonView.setMessage("请求失败!");
        }
        return jsonView;
    }

    @RequestMapping(value = "/insertShareOrder",method = RequestMethod.POST)
    public JsonView insertShareOrder(ShareOrder shareOrder){
        JsonView jsonView = new JsonView();
        try {
            shareOrderService.insertShareOrder(shareOrder);
            jsonView.setTodoCount(1);
            jsonView.setMessage("添加数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(shareOrder);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.EXPIRED);
            jsonView.setMessage("请求失败!");
        }
        return jsonView;
    }

    @RequestMapping(value = "/uodateShareOrder",method = RequestMethod.POST)
    public JsonView uodateShareOrder(ShareOrder shareOrder){
        JsonView jsonView = new JsonView();
        try {
            shareOrderService.uodateShareOrder(shareOrder);
            jsonView.setTodoCount(1);
            jsonView.setMessage("修改数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(shareOrder);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.EXPIRED);
            jsonView.setMessage("请求失败!");
        }
        return jsonView;
    }

    @RequestMapping("/selectShareOrderInfo")
    public JsonView selectShareOrderInfo(long merchantId, int payStatus){
        JsonView jsonView = new JsonView();
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("merchantId",merchantId);
            map.put("payStatus",payStatus);
            ShareOrderInfo shareOrderInfo = shareOrderService.selectShareOrderInfo(map);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求数据成功");
            jsonView.setData(shareOrderInfo);
            jsonView.setTodoCount(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.EXPIRED);
            jsonView.setMessage("请求失败!");
        }
        return jsonView;
    }

}
