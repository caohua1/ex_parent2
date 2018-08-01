package com.ex.controller.merchant_app_controller.videoEnjoyManageController;

import com.ex.entity.MerchantorpersonUploadProduct;
import com.ex.service.MerchantorpersonUploadProductService;
import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.vo.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * App商家视享
 */
@RestController
@RequestMapping("/UploadAPPvideo")
public class UploadAppvideoController {

    @Autowired
    private MerchantorpersonUploadProductService merchantorpersonUploadProductService;

    /**
     * app端商家上传视视频
     * @param Files
     * @param describe
     * @param link
     * @param productInfoId
     * @param request
     * @return
     */
    @RequestMapping("insertAPPUploadProduct")
    public JsonView insertMerchantorpersonUploadProduct(MultipartFile[] Files,String describe,String link,Long productInfoId,Long merchantId,Integer jumpType,HttpServletRequest request){
        JsonView jsonView= new JsonView();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        MerchantorpersonUploadProduct merchantorpersonUploadProduct=new MerchantorpersonUploadProduct();
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try{
            if(Files!=null||Files.length>0){
                for (MultipartFile multipartFile:Files
                     ) {
                    entity = fileUploadTool.createFile(multipartFile, request);
                    merchantorpersonUploadProduct.setFileUrl(entity.getPath());
                }
            }if(merchantId!=null){
                merchantorpersonUploadProduct.setMerchantId(merchantId);
            }if(describe!=null&&describe!=""){
                merchantorpersonUploadProduct.setDescribe(describe);
            }if(link!=null&&link!=""){
                merchantorpersonUploadProduct.setLink(link);
            }if(productInfoId!=null){
                merchantorpersonUploadProduct.setProductInfoId(productInfoId);
            }if(jumpType!=null){
                merchantorpersonUploadProduct.setJumpType(jumpType);
            }
            merchantorpersonUploadProduct.setUploadfileTime(df.parse(df.format(new Date())));//获取系统当前时间
            int i = merchantorpersonUploadProductService.insertMerchantorpersonUploadProduct(merchantorpersonUploadProduct);
            if(i>0){
                jsonView.setMessage("添加数据成功");
            }else {
                jsonView.setMessage("添加数据失败");
            }
        }catch (Exception e) {
             e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }

    /**
     * 根据商家id查询商品
     * @param merchantId
     * @return
     */
    public JsonView selectProductList(Long merchantId){
        JsonView jsonView= new JsonView();
        try{

        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }
}
