package com.ex.util;

import com.baidu.aip.ocr.AipOcr;
import com.ex.entity.BusinessLicenseInfo;
import com.ex.vo.FileEntity;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 百度第三方文字识别SDK
 */
public class BaiduOcrtools {
    //设置APPID/AK/SK
    public static final String APP_ID = "11379838";
    public static final String API_KEY = "tH4CzoAvesCe7nucM2Sc14Iv";
    public static final String SECRET_KEY = "uNrAr4emqeOnynDkwQQwiyBfWIYvoGn1";
    private static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
    private static long starTime;
    private static long endTime;

    public static void main(String[] args) throws Exception {
//        idCard(client);
//        business(client);
        Map<String, String> outMap = business("C:/acp/yyzz.jpg");
        outMap.put("", "");
    }

    /**
     * 身份证识别
     *
     * @param path
     * @return Json
     */
    public static Map<String, String> idCard(String path) throws Exception {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "back";

        // 参数为本地图片路径
        String image = path;
        JSONObject res = client.idcard(image, idCardSide, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = ImageBinaryTools.getImageBinary(image);
        res = client.idcard(file, idCardSide, options);
        System.out.print(res.toString(2));
        return jsonToObject(res.toString(2));
    }

    /**
     * 营业执照识别
     *
     * @param path
     * @return Json
     */
    public static Map<String, String> business(String path) throws Exception {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();

        // 参数为本地图片路径
        String image = path;
        JSONObject res = client.businessLicense(image, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = ImageBinaryTools.getImageBinary(image);
        res = client.businessLicense(file, options);
        System.out.print(res.toString(2));
        return jsonToObject(res.toString(2));
    }

    /**
     * 遍历返回的json数据，仅用于百度返回json遍历
     *
     * @param jsonStr
     * @return Map
     * @throws Exception
     */
    private static Map<String, String> jsonToObject(String jsonStr) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<?, ?> map = mapper.readValue(jsonStr, Map.class);
            map = (Map<?, ?>) map.get("words_result");
            Map<String, String> map3 = new HashMap<String, String>();
            Iterator<?> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                String newkey = key.toString();
                Map<?, ?> map2 = (Map<?, ?>) map.get(key);
                String value = map2.get("words").toString();
                map3.put(newkey, value);
            }
            return map3;
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验认证信息
     *
     * @param idCardPicUrl_Z
     * @param charterPicUrl
     * @param request
     * @param businessLicenseInfo
     * @return
     */
    public static Map<String, Object> chackCertification(MultipartFile charterPicUrl, MultipartFile idCardPicUrl_Z, MultipartFile idCardPicUrl_F, MultipartFile idCardPic, HttpServletRequest request, BusinessLicenseInfo businessLicenseInfo) {
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        Map<String, String> businessMap =  new HashMap<String, String>();
        Map<String, Object> ret = new HashMap<String, Object>();
        try {
            if (charterPicUrl != null) {
                entity = fileUploadTool.createFile(charterPicUrl, request);
                if (entity != null) {
                    System.out.println("返回报文---" + entity);
                    System.out.println("C:/acp/" + entity.getPath().toString());
                    businessMap = BaiduOcrtools.business("C:/acp/" + entity.getPath());
                    businessLicenseInfo.setCompanyname(businessMap.get("单位名称") == null ? "无" : businessMap.get("单位名称"));
                    businessLicenseInfo.setLegalperson(businessMap.get("法人") == null ? "无" : businessMap.get("法人"));
                    businessLicenseInfo.setSocialcreditcode(businessMap.get("社会信用代码") == null ? "无" : businessMap.get("社会信用代码"));
                    businessLicenseInfo.setValidityperiod(businessMap.get("有效期") == null ? "无" : businessMap.get("有效期"));
                    businessLicenseInfo.setCompanyaddress(businessMap.get("地址") == null ? "无" : businessMap.get("地址"));
                    businessLicenseInfo.setMerchantidnumber(businessMap.get("证件编号") == null ? "无" : businessMap.get("证件编号"));
                    businessLicenseInfo.setEstablishmentdate(businessMap.get("成立日期") == null ? "无" : businessMap.get("成立日期"));
                    if (businessLicenseInfo.getCompanyname().equals("无") ||
                            businessLicenseInfo.getLegalperson().equals("无") ||
                            businessLicenseInfo.getSocialcreditcode().equals("无") ||
                            businessLicenseInfo.getValidityperiod().equals("无") ||
                            businessLicenseInfo.getCompanyaddress().equals("无") ||
                            businessLicenseInfo.getEstablishmentdate().equals("无")) {
                        // 1002营业执照有遮挡
                        ret.put("code", 1002);
                        return ret;
                    }
                } else {
                    //1001图片上传失败
                    ret.put("code", 1001);
                    return ret;
                }
                ret.put("charterPicUrl", entity.getPath());
            }
//            if (idCardPicUrl_Z != null) {
//                entity = fileUploadTool.createFile(idCardPicUrl_Z, request);
//                if (entity != null) {
//                    System.out.println("返回报文---" + entity);
//                    //businessMap = //BaiduOcrtools.idCard("C:/acp/" + entity.getPath());
//                    businessLicenseInfo.setRealname(businessMap.get("姓名") == null ? "无" : businessMap.get("姓名"));
//                    businessLicenseInfo.setIdcard(businessMap.get("公民身份号码") == null ? "无" : businessMap.get("公民身份号码"));
//                    businessLicenseInfo.setBirthday(businessMap.get("出生") == null ? "无" : businessMap.get("出生"));
//                    if(businessMap.get("性别")==null){
//                        businessLicenseInfo.setSex(3);
//                    }else{
//                    businessLicenseInfo.setSex(businessMap.get("性别") == "男" ? 1 : 0);}
//                    businessLicenseInfo.setAddress(businessMap.get("地址") == null ? "无" : businessMap.get("地址"));
//                    businessLicenseInfo.setNational(businessMap.get("民族") == null ? "无" : businessMap.get("民族"));
//                    if (businessLicenseInfo.getRealname().equals("无") ||
//                            businessLicenseInfo.getIdcard().equals("无") ||
//                            businessLicenseInfo.getBirthday().equals("无") ||
//                            businessLicenseInfo.getSex()==3 ||
//                            businessLicenseInfo.getAddress().equals("无") ||
//                            businessLicenseInfo.getNational().equals("无")) {
//                        // 1003身份证有遮挡
//                        ret.put("code", 1003);
//                        return ret;
//                    }
//                } else {
//                    ret.put("code", 1001);
//                    return ret;
//                }
//                ret.put("idCardPicUrl_Z", entity.getPath());
//            }
            if (idCardPicUrl_F != null) {
                entity = fileUploadTool.createFile(idCardPicUrl_F, request);
                if (entity != null) {
                    ret.put("idCardPicUrl_F", entity.getPath());
                } else {
                    //1001图片上传失败
                    ret.put("code", 1001);
                    return ret;
                }
            }
            if (idCardPic != null) {
                entity = fileUploadTool.createFile(idCardPic, request);
                if (entity != null) {
                    ret.put("idCardPic", entity.getPath());
                } else {
                    //1001图片上传失败
                    ret.put("code", 1001);
                    return ret;
                }
            }
            ret.put("code", 200);
            ret.put("businessLicenseInfo", businessLicenseInfo);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("code", 1001);
            return ret;
        }
    }

}
