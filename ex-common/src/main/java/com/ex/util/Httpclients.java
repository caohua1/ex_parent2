package com.ex.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * 请求访问工具类
 */
public class Httpclients {
    public JSONObject doget(String url){
        JSONObject jsonObject=null;


        //以http的get的方式请求
        HttpGet httpGet = new HttpGet(url);
        //创建https协议的httpclient
        SSLClient sslClient;
        try {
            sslClient = new SSLClient();

            //发送请求
            HttpResponse httpResponse;

            try {
                httpResponse = sslClient.execute(httpGet);

                if(httpResponse.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                    //获取返回的响应信息
                    String str= EntityUtils.toString(httpResponse.getEntity(), "utf-8");
                    //输出响应信息
                    jsonObject = new JSONObject(str);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //验证返回的信息
        return jsonObject;

    }
    public JSONObject doPost(String url,JSONObject jsonDate){
        //返回的json
        JSONObject jsonObject =null;

        //运用https
        try {
            //制定post请求
            HttpPost httpPost=new HttpPost(url);
            //创建https协议的httpclient
            SSLClient sslClient = new SSLClient();
            //	发送请求
            HttpResponse httpResponse;

            //封装post请求数据
            StringEntity Entity = new StringEntity(jsonDate.toString(),"utf-8");
            httpPost.setEntity(Entity);
            //用https来访问这个post请求
            httpResponse = sslClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
                String str = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
                jsonObject =new JSONObject(str);
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return jsonObject;
    }

}
