package com.ex.controller.merchant_pc_controller.merchantController;

import com.ex.entity.MerchantInviter;
import com.ex.entity.MerchantorpersonCheckIn;
import com.ex.service.MerchantInviterService;
import com.ex.service.MerchantorpersonCheckInService;
import com.ex.util.JsonView;
import com.ex.util.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/merchantpc")
public class MerchantorpersonCheckInPCController {

    @Autowired
    private MerchantorpersonCheckInService merchantorpersonCheckInService;

    @Autowired
    private MerchantInviterService merchantInviterService;

    /**
     * 审核商家
     *
     * @param merchantorpersonCheckIn
     * @return
     */
    @RequestMapping(value = "/auditthemerchant", method = RequestMethod.POST)
    public JsonView auditTheMerchant(MerchantorpersonCheckIn merchantorpersonCheckIn) {
        JsonView jsonView = new JsonView();
        merchantorpersonCheckIn.setUpdatetime(new Date());
        try {
            //审核商家
            merchantorpersonCheckInService.auditTheMerchant(merchantorpersonCheckIn.getId(), merchantorpersonCheckIn.getStatus(), merchantorpersonCheckIn.getCauseby(),merchantorpersonCheckIn.getUpdatetime());
            //判断商家是否审核通过
            if (merchantorpersonCheckIn.getStatus() == 3) {
                //审核通过生成邀请码
                MerchantInviter merchantInviter = new MerchantInviter();
                merchantInviter.setInvitermerchantid(merchantorpersonCheckIn.getMerchantId());
                merchantInviter.setCreatetime(new Date());
                merchantInviter.setStatus(0);
                merchantInviterService.insertMerchantInviter(merchantInviter);
                //检查商家入住时是否有邀请码
                if (merchantorpersonCheckIn.getInvitercode() != null) {
                    MerchantInviter merchantInviter1 = merchantInviterService.selectInvitercodeByInvitercode(merchantorpersonCheckIn.getInvitercode());
                    if (merchantInviter1.getStatus() == 0) {
                        merchantInviter1.setStatus(1);
                    } else if (merchantInviter1.getStatus() == 1) {
                        merchantInviter1.setStatus(2);
                        // TODO 商家完成1+2分享模式，进行返利
                    } else {
                        merchantInviter1.setStatus(2);
                    }
                    merchantInviter1.setUpdatetime(new Date());
                    merchantInviterService.updateInvitercode(merchantInviter1);
                }
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("提交成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "审核失败!");
        }
        return null;
    }

    /**
     * 按条件查询商家邀请信息
     *
     * @param page
     * @param merchantInviter
     * @return
     */
    @RequestMapping("/byConditionsQuery")
    public JsonView byConditionsQuery(PageRequest page, MerchantInviter merchantInviter) {
        JsonView jsonView = new JsonView();
        try {
            PageInfo<MerchantInviter> pageInfo = merchantInviterService.byConditionsQuery(page, merchantInviter);
            jsonView.setMessage("查询数据成功!");
            jsonView.setData(pageInfo);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(pageInfo.getSize());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "查询数据失败!");
        }
        return jsonView;
    }

    /**
     * 按商家id查询邀请码
     *
     * @param invitermerchantid
     * @return
     */
    @RequestMapping("/selectInvitercode")
    public JsonView selectInvitercode(Long invitermerchantid) {
        JsonView jsonView = new JsonView();
        try {
            MerchantInviter merchantInviter = merchantInviterService.selectInvitercode(invitermerchantid);
            jsonView.setMessage("查询数据成功!");
            jsonView.setData(merchantInviter);
            jsonView.setCode(JsonView.SUCCESS);
            jsonView.setTodoCount(1);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonView.fail(JsonView.EXPIRED, "查询数据失败!");
        }
        return jsonView;
    }

}
