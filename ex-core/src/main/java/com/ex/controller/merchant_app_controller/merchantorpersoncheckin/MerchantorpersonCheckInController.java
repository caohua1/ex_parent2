package com.ex.controller.merchant_app_controller.merchantorpersoncheckin;

import com.ex.entity.BusinessLicenseInfo;
import com.ex.entity.IndustryClassify;
import com.ex.entity.MerchantorpersonCheckIn;
import com.ex.service.BusinessLicenseInfoService;
import com.ex.service.IndustryClassifyService;
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
import java.util.List;
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
     * 查询所有可显示的行业分类信息
     * @return
     */
    @RequestMapping("/getIndustryClassifyAll")
    private JsonView getIndustryClassifyAll(){
        JsonView jsonView = new JsonView();
        try {
            List<IndustryClassify> industryClassifyList = merchantorpersonCheckInService.getIndustryClassifyAll();
            jsonView.setTodoCount(industryClassifyList.size());
            jsonView.setData(industryClassifyList);
            jsonView.setMessage("请求数据成功!");
            jsonView.setCode(JsonView.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            jsonView.setMessage("请求失败");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 获取所有商家信息
     *
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
            jsonView.setTodoCount(pageInfo.getSize());
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
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
    public JsonView insertMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn, MultipartFile charterPicUrl, MultipartFile idCardPicUrl_Z, MultipartFile idCardPicUrl_F, MultipartFile idCardPic, HttpServletRequest request, int type) {
        JsonView jsonView = new JsonView();
        logger.info("Request comming to find insertMerchantorpersonCheckIn");
        try {
            //判断入驻信息是否存在
            logger.info("Request comming to find merchantorpersonCheckInService.selectByMerchantId");
            if (merchantorpersonCheckInService.selectByMerchantId(merchantorpersonCheckIn.getMerchantId(), merchantorpersonCheckIn.getCheckintype()) != null && type == 1) {
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("入驻信息已存在!");
                return jsonView;
            }
            BusinessLicenseInfo businessLicenseInfo = new BusinessLicenseInfo();
            businessLicenseInfo.setType(2);
            businessLicenseInfo.setMerchantid(merchantorpersonCheckIn.getMerchantId());
            businessLicenseInfo.setCreatetime(new Date());
            logger.info("Request comming to find businessLicenseInfoService.insertBusinessLicenseInfo");
            Map<String, Object> ret = businessLicenseInfoService.insertBusinessLicenseInfo(charterPicUrl, idCardPicUrl_Z, idCardPicUrl_F, idCardPic, request, businessLicenseInfo);
            String code = ret.get("code").toString();
            if (code.equals("1001")) {
                jsonView.setMessage("提交失败，请重新上传!");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            if (code.equals("1002")) {
                jsonView.setMessage("营业执照有遮挡，请重新上传!");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            if (code.equals("1003")) {
                jsonView.setMessage("营业执照有遮挡，请重新上传!");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            if (code.equals("1003")) {
                jsonView.setMessage("身份证模糊，请重新上传!");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            //得到扫描的图片信息
            businessLicenseInfo = (BusinessLicenseInfo) ret.get("businessLicenseInfo");
            if (merchantorpersonCheckIn.getCompanycode() != businessLicenseInfo.getSocialcreditcode()) {
                jsonView.setMessage("输入的社会信用代码与营业执照上的不符合!");
                jsonView.setCode(JsonView.ERROR);
                return jsonView;
            }
            merchantorpersonCheckIn.setCompanycreatetime(businessLicenseInfo.getEstablishmentdate());
            if (ret.get("charterPicUrl") != null)
                merchantorpersonCheckIn.setCharterpicurl(ret.get("charterPicUrl").toString());
            if (ret.get("idCardPicUrl_Z") != null)
                merchantorpersonCheckIn.setIdcardpicurlZ(ret.get("idCardPicUrl_Z").toString());
            if (ret.get("idCardPicUrl_F") != null)
                merchantorpersonCheckIn.setIdcardpicurlF(ret.get("idCardPicUrl_F").toString());
            if (ret.get("idCardPic") != null)
                merchantorpersonCheckIn.setIdcardpic(ret.get("idCardPic").toString());


            merchantorpersonCheckIn.setStatus(1);

            //判断是提交入驻信息还是修改入驻信息
            if (type == 1) {
                //提交入驻审核信息
                merchantorpersonCheckIn.setCheckintime(new Date());
                logger.info("Request comming to find merchantorpersonCheckInService.insertMerchantorpersonCheckIn");
                merchantorpersonCheckInService.insertMerchantorpersonCheckIn(merchantorpersonCheckIn);
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("提交成功!等待审核!");
            } else if (type == 2) {
                merchantorpersonCheckIn.setUpdatetime(new Date());
                logger.info("Request comming to find merchantorpersonCheckInService.selectByMerchantId");
                MerchantorpersonCheckIn checkIn = merchantorpersonCheckInService.selectByMerchantId(merchantorpersonCheckIn.getMerchantId(), merchantorpersonCheckIn.getCheckintype());
                //检查认证信息是否处于待审核状态
                if (checkIn.getStatus() == 1) {
                    jsonView.setMessage("入驻信息正在审核，不能修改!");
                    jsonView.setCode(JsonView.SUCCESS);
                    return jsonView;
                }
                logger.info("Request comming to find merchantorpersonCheckInService.updateMerchantorpersonCheckIn");
                //修改入驻审核信息
                merchantorpersonCheckInService.updateMerchantorpersonCheckIn(merchantorpersonCheckIn);
                jsonView.setMessage("修改成功!");
                jsonView.setCode(JsonView.SUCCESS);
            }


        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;

    }

    /**
     * 按条件查询认证信息
     *
     * @param page
     * @param merchantorpersonCheckIn
     * @return
     */
    @RequestMapping("/byConditionsQuery")
    public JsonView byConditionsQuery(PageRequest page, MerchantorpersonCheckIn merchantorpersonCheckIn) {
        JsonView jsonView = new JsonView();
        try {
            PageInfo<MerchantorpersonCheckIn> pageInfo = merchantorpersonCheckInService.byConditionsQuery(page, merchantorpersonCheckIn);
            jsonView.setData(pageInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询数据成功");
            jsonView.setTodoCount(pageInfo.getSize());
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 按注册人Id和入住类型查询
     *
     * @param merchantId
     * @param checkInType
     * @return
     */
    @RequestMapping("/selectByMerchantId")
    public JsonView selectByMerchantId(Long merchantId, int checkInType) {
        JsonView jsonView = new JsonView();
        try {
            MerchantorpersonCheckIn merchantorpersonCheckIn = merchantorpersonCheckInService.selectByMerchantId(merchantId, checkInType);
            jsonView.setData(merchantorpersonCheckIn);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setMessage("查询数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }

    /**
     * 商家支付
     *
     * @param merchantorpersonCheckIn
     * @return
     */
    @RequestMapping("updateMerchant")
    public JsonView payMerchantorpersonCheckIn(MerchantorpersonCheckIn merchantorpersonCheckIn) {
        JsonView jsonView = new JsonView();
        try {

        } catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }
}
