package com.ex.controller.merchant_pc_controller.PayManageController;

import com.ex.service.PcWeichatPayService;
import com.ex.util.JsonView;
import com.ex.util.weixinPay.QRCodeImgeUtil;
import com.ex.util.weixinPay.WXPayConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Map;

@RestController
@RequestMapping("/PcWeichatPayController")
public class PcWeichatPayController {

    @Autowired
    private PcWeichatPayService pcWeichatPayService;

    /**
     * 调用统一下单API，
     * 生成支付二维码返回给前端展示
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("pcWeichatPay")
    public JsonView pcWeichatPay(HttpServletRequest request, HttpServletResponse response){
        JsonView jsonView = new JsonView();
        QRCodeImgeUtil qrCodeImgeUtil = new QRCodeImgeUtil();
        try{
            Map<String, String> responseMap  = pcWeichatPayService.PcWeichatPay();
            System.out.println("controller返回值----"+responseMap);
            String returnCode = (String) responseMap.get("return_code");
            String resultCode = (String) responseMap.get("result_code");
            if (WXPayConstants.SUCCESS.equals(returnCode) && WXPayConstants.SUCCESS.equals(resultCode)) {
                String prepayId = (String) responseMap.get("prepay_id");
                String codeUrl = (String) responseMap.get("code_url");
                BufferedImage image = qrCodeImgeUtil.getQRCodeImge(codeUrl);
                response.setContentType("image/jpeg");
                response.setHeader("Pragma","no-cache");
                response.setHeader("Cache-Control","no-cache");
                response.setIntHeader("Expires",-1);
                ImageIO.write(image, "JPEG", response.getOutputStream());
            }
        }catch (Exception e) {
            e.printStackTrace();
            jsonView.setMessage("请求失败!");
            jsonView.setCode(JsonView.EXPIRED);
        }
        return jsonView;
    }
}
