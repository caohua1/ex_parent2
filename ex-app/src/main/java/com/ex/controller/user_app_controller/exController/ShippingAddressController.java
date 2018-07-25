package com.ex.controller.user_app_controller.exController;

import com.ex.entity.ShippingAddress;
import com.ex.service.ShippingAddressService;
import com.ex.util.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shippingAdress")
public class ShippingAddressController {
    @Autowired
    private ShippingAddressService shippingAddressService;

    /**
     * 用户添加新的收货地址
     * @param shippingAddress
     * @return
     */
    @RequestMapping("/insertShippingAddress")
    public JsonView insertShippingAddress(ShippingAddress shippingAddress){
        JsonView jsonView = new JsonView();
        try{
            shippingAddress.setCreateTime(new Date());
            Integer i = shippingAddressService.insertShippingAddress(shippingAddress);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("添加成功");
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("添加异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }


    /**
     * 查询用户所有添加的收货地址
     * @param registUserId
     * @return
     */
    @RequestMapping("/selectShippingAddress")
    public JsonView selectShippingAddress(Long registUserId){
        JsonView jsonView = new JsonView();
        try{
            List<ShippingAddress> shippingAddresses = shippingAddressService.selectShippingAddress(registUserId);
            if(shippingAddresses!=null && shippingAddresses.size()>0){
                jsonView.setMessage("查询成功");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setData(shippingAddresses);
            }else{
                jsonView.setMessage("请添加收货地址");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("查询异常");
        }
        return jsonView;
    }

    /**
     * 编辑收货地址（删除status=0）
     * @param shippingAddress
     * @return
     */
    @RequestMapping("/updateAddress")
    public JsonView updateAddress(ShippingAddress shippingAddress){
        JsonView jsonView = new JsonView();
        try{
            shippingAddress.setUpdateTime(new Date());
            Integer i = shippingAddressService.updateAddressById(shippingAddress);
            if(i>0){
                jsonView.setMessage("操作成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("操作失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("操作异常");
        }
        return jsonView;
    }
}
