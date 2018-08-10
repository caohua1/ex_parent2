package com.ex.controller.merchant_pc_controller.videoEnjoyManageController;

import com.ex.entity.MerchantorpersonUploadProduct;
import com.ex.entity.MusicManage;
import com.ex.service.MerchantorpersonUploadProductService;
import com.ex.service.MusicManageService;
import com.ex.util.FileUploadTool;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.ex.vo.FileEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/UploadPcvideo")
public class UploadPCvideoController {

    @Autowired
    private MerchantorpersonUploadProductService merchantorpersonUploadProductService;

    @Autowired
    private MusicManageService musicManageService;

    /**
     * PC端商家上传视视频
     * @param Path
     * @param describe
     * @param link
     * @param productInfoId
     * @param request
     * @return
     */
    @RequestMapping("insertMerchantorpersonUploadProduct")
        public JsonView insertMerchantorpersonUploadProduct(String Path,String describe,String link,Long productInfoId,Long merchantId,Integer jumpType,Long productClassifyId,Long musicId,HttpServletRequest request){
        JsonView jsonView= new JsonView();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        MerchantorpersonUploadProduct merchantorpersonUploadProduct=new MerchantorpersonUploadProduct();

        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try{
            if(Path!=null&&Path!=""){
                merchantorpersonUploadProduct.setFileUrl(Path);
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
            }if(productClassifyId!=null){
                merchantorpersonUploadProduct.setProductClassifyId(productClassifyId);
            }if(musicId!=null){
                merchantorpersonUploadProduct.setMusicId(musicId);
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
     * 商家App选择背景音乐
     * @param page
     * @return
     */
    @RequestMapping("PCselectMusicManage")
    public JsonView selectMusicManage(PageRequest page){
        JsonView jsonView= new JsonView();
        try{
            PageInfo<MusicManage> musicManagePageInfo = musicManageService.selectMusicManage(page);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询成功");
            jsonView.setData(musicManagePageInfo);
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.fail();
        }
        return jsonView;
    }
}
