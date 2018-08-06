package com.ex.controller.merchant_app_controller.merchantorpersoncheckin;

import com.ex.entity.StoreInfo;
import com.ex.service.StoreInfoService;
import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.FileEntity;
import com.ex.vo.StoreInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 开店铺
 */
@RestController
@RequestMapping("/merchant/store")
public class StoreInfoController {

    @Autowired
    private StoreInfoService storeInfoService;

    /**
     * 开店铺
     * @param storeInfo
     * @return
     */
    @RequestMapping(value = "/openStore",method = RequestMethod.POST)
    public JsonView openStore(StoreInfo storeInfo, MultipartFile Files, HttpServletRequest request) {
        JsonView jsonView = new JsonView();
        try {
            FileUploadTool fileUploadTool = new FileUploadTool();
            FileEntity entity = fileUploadTool.createFile(Files, request);//上传每个文件
            storeInfo.setAdvertisingpicurl(entity.getPath());//拼接文件上传的地址以“,”号隔开
            int i = storeInfoService.insertStoreInfo(storeInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("开通成功!");
            jsonView.setData(storeInfo);
            jsonView.setTodoCount(i);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 修改店铺信息
     * @param storeInfo
     * @return
     */
    @RequestMapping(value = "/updateStore",method = RequestMethod.POST)
    public JsonView updateStoreInfo(StoreInfo storeInfo) {
        JsonView jsonView = new JsonView();
        try {
            int i = storeInfoService.updateStoreInfo(storeInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("修改成功!");
            jsonView.setData(storeInfo);
            jsonView.setTodoCount(i);
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 按条件查询店铺信息j
     * @param page
     * @param storeInfo
     * @return
     */
    public JsonView byConditionsQuery(PageRequest page, StoreInfoVo storeInfo) {
        JsonView jsonView = new JsonView();
        try {
            PageInfo<StoreInfoVo> pageInfo = storeInfoService.byConditionsQuery(page, storeInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("请求数据成功!");
            jsonView.setData(pageInfo);
            jsonView.setTodoCount(pageInfo.getSize());
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }
}
