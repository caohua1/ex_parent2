package com.ex.util;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id ="2016091400506612";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCBIZgtPEv+Fltzjq9U9/14aOvgNO+4RCG2B8dMZYnWbcpXF5zCjOpOM+51X7X/keeTh9WtyhpR1ESCmJNpm3tiaKRcuElVkcxYYhUQizOE3Fhsj4qlShmCMPDGffNtxA3thvXDZz0as8yTxQ7zIx2RlgmWbZQU7e39DEKsVNpzWXvWTRRkjJ3CU/L5bNi5xJGsal8MXsaUfMCnvmlOzX0jTg3luyZb3XouI0ZVcHMv2AW62SOMYMZLkfUNuPxnSD0rfWSo9qRGzC7Qc+cXM3ZvQk4sq4xTm8eez5CgmP08KJD6D1nS+14Ksc+Kzg9qLbbp80GCZNAr7g+tr5I885jHAgMBAAECggEAFtciW532sxKxSldKm/ThWJL2Zcn3PNiQPepSTikHoG37BDyg9aiHKR32Z7xuLK5aD7ZPDVZaIW8yTwc9y8g8osNvjxbpocEQK/HtV+fHTRDMcydQlrvslyKg8/sDO78Z15GvlsiD/l0fKmQIqOjlKgMn3vuy3aDYH5IzmNfJa+1/Z4oCqYB5ISn7CKWFJhtxMYQoNy5xeBCoGkeLTbKfxNv11QOWcpsql0F7c6V/AfoNf/mxQas8vSIXZW2q79XTRigjIohDp9HLmjvIqF1IK5OrlF6u0YbUOhTQ9aDdEU30ckzvnzXKMmfzsDdzo6Et0wya7m8lM8kdjMQ3+FFaQQKBgQDHtr9LVXAWvmTQ6nsx86VtVaR9RCMJhC8mO4Rc0fX8uwEcYRCRtJ4jZ4bdVNB6WkMgusCjXV/cBMLcrHxSs0p02OaAZ4SukfNH7Wza72dfraVOyR2vefPQJorOmwJe3kBRHt9v6Ijsfx08ZUQdsXppyvljwLZ73vW9DhZlmAy7iwKBgQClhli8FZRBBDgBq0mu/1nQIgGPM641aUy3VRce7DEhi42L6M8TXj7e8AoQjWmssxtay/6t3iodgPXdBzLC2IvCZ4nKDItw2Jd1BSOa0OtZKqY0CWaSHNgSTdgJWA39i8aN8LX3bZiS7qWT2X/3IVyFvWYI+XbGA4LOKj9/DO7vNQKBgQCaHpYrPai9dHp6mqktmDfOUywYG0/qlR6Jo552vvTU7z9hNirCNp9e9RKnlT85XJS3Gkd1CqbiNK5n+5gJfiD0YTooVzqWOT2EAV5i6iNdO7T5Qszs0PDtbgDqhcbjjSIXN/r38nxP/ZyDMibJv1+XarLgXyS0HRCIr+lqx1b0FwKBgQCTfnlHb/shTD8Tzavk0gkX25WEI0sSsPf5TUtC9Lh66b2BdDxBR/PB+CcfxMLrbtXrPGd+Sr9Adw+emrFyyj8PRe+UKUV/kqCzV5b4dz2fwM9FAzNw817eQJtHCD2/NnQBOwMKrZANLbZBXsgWUJX/Xluzl4dsvugqCZ92+PFYGQKBgQDGHr/1FCl+sgmb8XJwrKzJT9K99Asu7EMruRhaIbkOE2oGLLVHNFTWiqod7GkZ++hwb/1SS/vG+PRd+iBqaww1uStFSaz7kT7s6Qmrev08pwHDPtAkVHTQVWKf+kOw9PaUnKb99mra1nZq0+sgST+EWvO7BVo99DEQSvVkT4u4+w==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo/IlrU90idwwhFui8ScOBe6TBypdEqZomwCNcP5oZl4qdeGUUnBL6gZzy7uXY1AaGH8NHqV7OJavaQ6tuWGWdIbh/z0EoBHakzANCof6L76ZszL1ckW5iliAdV9kyLAifaB4AtcCg/Mz9gI2cbKSBQlbO6aI0KH/XgcG/vBISE1cX9hFr1bZK0EDnEzK7yhR7/MG766c6u0m8hx0FSNtmH733mU2qzjs0u53quuFTgwUtkp6RWw/VEEs/CyMlgROasaRlPo3YyExou0898FVduTusBpF9uJoDVyBjd4KnvS6S/ZXSkaYUsiXHN/2Wvlu0mcUSt+jdr5kMzBOXe6hewIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://zxvgv1m.hk1.mofasuidao.cn/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://zxvgv1m.hk1.mofasuidao.cn/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    //生产环境https://openapi.alipay.com/gateway.do
    //测试环境https://openapi.alipaydev.com/gateway.do
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";
}
