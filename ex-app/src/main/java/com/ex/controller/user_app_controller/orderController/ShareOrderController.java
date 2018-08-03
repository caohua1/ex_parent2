package com.ex.controller.user_app_controller.orderController;

import com.ex.service.ShareOrderService;
import com.ex.service.ShareProductService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.ShareOrderInfoVo;
import com.ex.vo.ShareOrderVo;
import com.ex.vo.ShareProductVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/user/order")
public class ShareOrderController {

    @Autowired
    private ShareOrderService shareOrderService;
    @Autowired
    private ShareProductService shareProductService;

    private SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 按用户id查询所有的分享订单信息
     *
     * @param shareUserId
     * @param page
     * @return
     */
    @RequestMapping("/selectShareOrderByUserId")
    public JsonView selectShareOrderByUserId(Long shareUserId, PageRequest page) {
        JsonView jsonView = new JsonView();
        try {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            List<ShareProductVo> shareProductVos = shareProductService.selectShareProductById(shareUserId);
            PageInfo<ShareProductVo> pageInfo = new PageInfo<>(shareProductVos);
            List<ShareProductVo> shareProductVos1 = pageInfo.getList();
            for (ShareProductVo sp : shareProductVos1) {
                sp.setShareOrderVos(shareOrderService.selectShareOrderByShareUserIdAll(sp.getShareUserId(), sp.getProductInfoId()));
                for (ShareOrderVo vo : sp.getShareOrderVos()) {
                    if (vo.getFinishTime() != null) {
                        if (sf.format(vo.getFinishTime()).compareTo(sf.format(new Date())) > 0) {
                            vo.setStatusStr("交易完成!");
                        } else {
                            vo.setStatusStr("交易进行中!");
                        }
                    } else {
                        vo.setStatusStr("交易进行中!");
                    }
                }
            }
            jsonView.setTodoCount(shareProductVos.size());
            jsonView.setMessage("请求数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 用户APP我的分享顶部数据
     * @param userId 用户ID
     * @return
     */
    @RequestMapping("/selectShareOrederInfo")
    public JsonView selectShareOrederInfo(Long userId){
        JsonView jsonView = new JsonView();
        try{
            ShareOrderInfoVo shareOrderInfoVo = shareOrderService.selectShareOrederInfoVo(userId);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求成功!");
            jsonView.setData(shareOrderInfoVo);
            jsonView.setTodoCount(1);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.EXPIRED);
            jsonView.setMessage("请求失败!");
        }
        return jsonView;
    }

}
