package com.ex.controller.merchant_app_controller.Pay;

/**
 * 包括沙箱及正式版(网关地址,APPID,私钥,公钥均不同)
 */
public class AlipayConfig {

    //网关地址
    //public static final String URL = "https://openapi.alipay.com/gateway.do"; //(正式环境)
    public static final String URL = "https://openapi.alipaydev.com/gateway.do"; //沙箱(测试环境)

    //APPID
    public static final String ALIPAY_APPID = "2016091400506612";

    //私钥
    public static String APP_PRIVATE_KEY = "<使用开放平台提供的工具生成>";
    //支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "<使用开放平台提供的工具生成>";

    //签名算法类型(根据生成私钥的算法,RSA2或RSA)
    public static final String SIGNTYPE = "RSA";

    public static final String FORMAT = "json";//请求数据格式
    public static final String CHARSET = "utf-8";//编码集

    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static final String APPnotify = "http://....../alipay/APPnotify";//APP

}
