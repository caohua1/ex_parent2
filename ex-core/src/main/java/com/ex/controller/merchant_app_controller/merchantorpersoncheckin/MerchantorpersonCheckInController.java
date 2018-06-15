package com.ex.controller.merchant_app_controller.merchantorpersoncheckin;

import com.ex.entity.BusinessLicenseInfo;
import com.ex.entity.MerchantorpersonCheckIn;
import com.ex.service.BusinessLicenseInfoService;
import com.ex.service.MerchantorpersonCheckInService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/merchant/in")
public class MerchantorpersonCheckInController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private MerchantorpersonCheckInService merchantorpersonCheckInService;

    @Autowired
    private BusinessLicenseInfoService businessLicenseInfoService;

    @RequestMapping("/all")
    public JsonView findByPage(PageRequest page) {
        try {
            logger.info("Request comming to find merchantorpersonCheckIn list...");
            PageInfo<MerchantorpersonCheckIn> pageInfo = merchantorpersonCheckInService.findByPage(page);
            return JsonView.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "服务器错误!");
        }
    }

    /**
     * 商家入驻
     * @param merchantorpersonCheckIn
     * @param charterPicUrl 营业执照
     * @param idCardPicUrl_Z 身份证正面
     * @param idCardPicUrl_F 身份证反面
     * @param idCardPic 手持身份证
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkin",method = RequestMethod.POST)
    public JsonView insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn,MultipartFile charterPicUrl, MultipartFile idCardPicUrl_Z, MultipartFile idCardPicUrl_F,MultipartFile idCardPic, HttpServletRequest request){
        try {
            BusinessLicenseInfo businessLicenseInfo = new BusinessLicenseInfo();
            businessLicenseInfo.setType(2);
            businessLicenseInfo.setMerchantid(merchantorpersonCheckIn.getMerchantid());
            businessLicenseInfo.setCreatetime(new Date());
            Map<String,Object> ret = businessLicenseInfoService.insertBusinessLicenseInfo(charterPicUrl,idCardPicUrl_Z,idCardPicUrl_F,idCardPic,request,businessLicenseInfo);
            String code = ret.get("code").toString();
            if(code.equals("1001")){
                return JsonView.fail("提交失败，请重新上传!");
            }
            if(code.equals("1003")){
                return  JsonView.fail("营业执照有遮挡，请重新上传!");
            }
            if(code.equals("1003")){
                return  JsonView.fail("身份证模糊，请重新上传!");
            }
            businessLicenseInfo = (BusinessLicenseInfo) ret.get("businessLicenseInfo");
            merchantorpersonCheckIn.setCompanycreatetime(sf.parse(businessLicenseInfo.getEstablishmentdate()));
            merchantorpersonCheckIn.setCharterpicurl(ret.get("charterPicUrl").toString());
            merchantorpersonCheckIn.setIdcardpicurlZ(ret.get("idCardPicUrl_Z").toString());
            merchantorpersonCheckIn.setIdcardpicurlF(ret.get("idCardPicUrl_F").toString());
            merchantorpersonCheckIn.setIdcardpic(ret.get("idCardPic").toString());
            merchantorpersonCheckIn.setCheckintime(new Date());
            return JsonView.success("提交成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "服务器错误!");
        }
    }

    public JsonView byConditionsQuery(PageRequest page,MerchantorpersonCheckIn merchantorpersonCheckIn){
        try {
            return JsonView.success("");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "服务器错误!");
        }
    }
}
