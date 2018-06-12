package com.ex.util;

import com.baidu.aip.ocr.AipOcr;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

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
        outMap.put("","");
    }

    /**
     * 身份证识别
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
        return jsonToObject(res.toString(2));
    }

    /**
     * 营业执照识别
     * @param path
     * @return Json
     */
    public static  Map<String, String> business(String path) throws Exception {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();

        // 参数为本地图片路径
        String image = path;
        JSONObject res = client.businessLicense(image, options);
//        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = ImageBinaryTools.getImageBinary(image);
        res = client.businessLicense(file, options);
        return jsonToObject(res.toString(2));

    }

    /**
     * 遍历返回的json数据，仅用于百度返回json遍历
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
            while ( iterator.hasNext() ) {
                Object key = iterator.next();
                String newkey = key.toString();
                Map<?, ?> map2= (Map<?, ?>) map.get(key);
                String value = map2.get("words").toString();
                map3.put(newkey,value);
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


}
