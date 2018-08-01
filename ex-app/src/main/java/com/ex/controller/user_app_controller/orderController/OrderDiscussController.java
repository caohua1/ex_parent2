package com.ex.controller.user_app_controller.orderController;

import com.ex.entity.OrderDiscuss;
import com.ex.service.OrderDiscussService;
import com.ex.service.UserOrdersService;
import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.vo.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/order")
public class OrderDiscussController {

    @Autowired
    private OrderDiscussService orderDiscussService;

    @Autowired
    private UserOrdersService UserOrdersService;

    /**
     * 用户对订单进行评论
     * @param orderDiscuss
     * @return
     */
    @RequestMapping(value = "/insertOrderDiscuss",method = RequestMethod.POST)
    public JsonView insertOrderDiscuss(OrderDiscuss orderDiscuss,MultipartFile[] Files,HttpServletRequest request){
        JsonView jsonView = new JsonView();
        try{
            String pictureUrl = null;
            FileUploadTool fileUploadTool = new FileUploadTool();
            if(Files!=null||Files.length>0){
                //上传多个文件
                for (MultipartFile multipartFile:Files) {
                    FileEntity entity = fileUploadTool.createFile(multipartFile, request);//上传每个文件
                    pictureUrl +=entity.getPath()+",";//拼接文件上传的地址以“,”号隔开
                }
            }
            orderDiscuss.setPictureUrl(pictureUrl);
            int i = orderDiscussService.insertOrderDiscuss(orderDiscuss);
            if (i>0){
                Map<String,Object> map = new HashMap<>();
                map.put("id",orderDiscuss.getOrderId());
                map.put("status",14);
                UserOrdersService.updateOrdersStatusById(map);
                jsonView.setMessage("评论成功!");
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setTodoCount(i);
            }else {
                jsonView.setMessage("评论失败!");
                jsonView.setCode(JsonView.ERROR);
                jsonView.setTodoCount(i);
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

}
