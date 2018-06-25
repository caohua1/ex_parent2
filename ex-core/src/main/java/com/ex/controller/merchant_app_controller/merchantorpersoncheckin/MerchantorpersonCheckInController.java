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
import java.util.Date;
import java.util.Map;

/**
 * 商家入驻
 */
@RestController
@RequestMapping("/merchant/in")
public class MerchantorpersonCheckInController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MerchantorpersonCheckInService merchantorpersonCheckInService;

    @Autowired
    private BusinessLicenseInfoService businessLicenseInfoService;

    /**
     * 获取所有商家信息
     * @param page
     * @return
     */
    @RequestMapping("/all")
    public JsonView findByPage(PageRequest page) {
        JsonView jsonView = new JsonView();
        try {
            logger.info("Request comming to find merchantorpersonCheckIn list...");
            PageInfo<MerchantorpersonCheckIn> pageInfo = merchantorpersonCheckInService.findByPage(page);
            jsonView.setData(pageInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "服务器错误!");
        }
        return jsonView;
    }

    /**
     * 商家入驻
     *
     * @param merchantorpersonCheckIn
     * @param charterPicUrl           营业执照
     * @param idCardPicUrl_Z          身份证正面
     * @param idCardPicUrl_F          身份证反面
     * @param idCardPic               手持身份证
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkin", method = RequestMethod.POST)
    public JsonView insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn, MultipartFile charterPicUrl, MultipartFile idCardPicUrl_Z, MultipartFile idCardPicUrl_F, MultipartFile idCardPic, HttpServletRequest request) {
            JsonView jsonView = new JsonView();
        try {
            //判断入驻信息是否存在
            if (merchantorpersonCheckInService.selectByMerchantId(merchantorpersonCheckIn.getMerchantId(), merchantorpersonCheckIn.getCheckintype())!=null){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("入驻信息已存在!");
                return jsonView;
            }
            BusinessLicenseInfo businessLicenseInfo = new BusinessLicenseInfo();
            businessLicenseInfo.setType(2);
            businessLicenseInfo.setMerchantid(merchantorpersonCheckIn.getMerchantId());
            businessLicenseInfo.setCreatetime(new Date());
            Map<String, Object> ret = businessLicenseInfoService.insertBusinessLicenseInfo(charterPicUrl, idCardPicUrl_Z, idCardPicUrl_F, idCardPic, request, businessLicenseInfo);
            String code = ret.get("code").toString();
            if (code.equals("1001")) {
                return JsonView.fail("提交失败，请重新上传!");
            }
            if (code.equals("1003")) {
                return JsonView.fail("营业执照有遮挡，请重新上传!");
            }
            if (code.equals("1003")) {
                return JsonView.fail("身份证模糊，请重新上传!");
            }
            businessLicenseInfo = (BusinessLicenseInfo) ret.get("businessLicenseInfo");
            merchantorpersonCheckIn.setCompanycreatetime(businessLicenseInfo.getEstablishmentdate());
            if (ret.get("charterPicUrl") != null)
                merchantorpersonCheckIn.setCharterpicurl(ret.get("charterPicUrl").toString());
            if (ret.get("idCardPicUrl_Z") != null)
                merchantorpersonCheckIn.setIdcardpicurlZ(ret.get("idCardPicUrl_Z").toString());
            if (ret.get("idCardPicUrl_F") != null)
                merchantorpersonCheckIn.setIdcardpicurlF(ret.get("idCardPicUrl_F").toString());
            if (ret.get("idCardPic") != null)
                merchantorpersonCheckIn.setIdcardpic(ret.get("idCardPic").toString());
            merchantorpersonCheckIn.setCheckintime(new Date());
            merchantorpersonCheckIn.setStatus(1);
            merchantorpersonCheckInService.insertMerchantorpersonCheckIn(merchantorpersonCheckIn);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("提交成功!等待审核!");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "服务器错误!");
        }
        return jsonView;
    }

    /**
     * 按条件查询认证信息
     * @param page
     * @param merchantorpersonCheckIn
     * @return
     */
    @RequestMapping("/byConditionsQuery")
    public JsonView byConditionsQuery(PageRequest page, MerchantorpersonCheckIn merchantorpersonCheckIn) {
        JsonView jsonView = new JsonView();
        try {
            PageInfo<MerchantorpersonCheckIn> pageInfo = merchantorpersonCheckInService.byConditionsQuery(page,merchantorpersonCheckIn);
            jsonView.setData(pageInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "服务器错误!");
        }
        return jsonView;
    }

    /**
     * 按注册人Id和入住类型查询
     * @param merchantId
     * @param checkInType
     * @return
     */
    @RequestMapping("/selectByMerchantId")
    public JsonView selectByMerchantId(Long merchantId, int checkInType) {
        JsonView jsonView = new JsonView();
        try{
            MerchantorpersonCheckIn merchantorpersonCheckIn = merchantorpersonCheckInService.selectByMerchantId(merchantId, checkInType);
            if (merchantorpersonCheckIn!=null){
                jsonView.setData(merchantorpersonCheckIn);
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("查询数据成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED,"服务器错误!");
        }
        return jsonView;
    }

    /**
     * 修改入驻信息
     * @param merchantorpersonCheckIn
     * @return
     */
    @RequestMapping("updateMerchant")
    public JsonView updateMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn){
        JsonView jsonView = new JsonView();
        try{
            MerchantorpersonCheckIn checkIn = merchantorpersonCheckInService.selectByMerchantId(merchantorpersonCheckIn.getMerchantId(), merchantorpersonCheckIn.getCheckintype());
            //检查认证信息是否处于待审核状态
            if (checkIn.getStatus()==1){
                jsonView.setMessage("入驻信息正在审核，不能修改!");
                jsonView.setCode(JsonView.SUCCESS);
            }
            merchantorpersonCheckInService.updateMerchantorpersonCheckIn(merchantorpersonCheckIn);
            jsonView.setMessage("修改成功!");
            jsonView.setCode(JsonView.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED,"服务器错误!");
        }
        return jsonView;
    }
}
