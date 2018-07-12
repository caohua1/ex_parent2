package com.ex.util;

import com.ex.entity.MerchantRegist;
import com.ex.entity.UserAppRegist;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    //存放用户app Token
    public static Map<String, String> userTokenMap = new HashMap<String, String>();

    //存放用户Token对应的用户登陆信息
    public static Map<String, UserAppRegist> loginUserMap = new HashMap<String, UserAppRegist>();


    /**
     * 生成ToKen
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public static String UserToken(String username, String password, UserAppRegist userAppRegist) {

        String token = userTokenMap.get(username);

        /**
         * 判断是否是新用户登陆
         * 是 生成token返回
         * 不是 删除旧的token 生成新的token返回
         */
        if (token == null) {
            //先删除旧的存有用户信息的Token
            if(loginUserMap.get(userTokenMap.get(username))!=null)
                loginUserMap.remove(userTokenMap.get(username));
            //声成一个以用户名+密码+时间的 MD5 值作为 ToKen 存入 userTokenMap
            token = CustomMD5.passwordAndSalt(password, username + new Date().getTime(), 1);
            //将 token 存入 userTokenMap
            userTokenMap.put(username, token);

            //再将用户登陆的信息存入生成的 Token
            loginUserMap.put(token, userAppRegist);
            //返回生成的token
            return token;
        } else {
            //删除旧的token信息
            userTokenMap.remove(username);
            loginUserMap.remove(token);
            //声成一个以用户名+密码+时间的 MD5 值作为 ToKen 存入 userTokenMap
            token = CustomMD5.passwordAndSalt(password, username + new Date().getTime(), 1);
            //将 token 存入 userTokenMap
            userTokenMap.put(username, token);
            //将用户登陆的信息存入生成的 Token
            loginUserMap.put(token, userAppRegist);
            //返回生成的token
            return token;
        }
    }

    /**
     * 校验token是否有效 有效返回用户信息
     *
     * @param strtoken
     * @return
     */
    public static UserAppRegist userToken(String strtoken) {
        String token = userTokenMap.get(strtoken);
        if (token == null)
            return null;
        UserAppRegist userAppRegist = loginUserMap.get(token);
        return userAppRegist;
    }

    //存放商家app Token
    public static Map<String, String> MerchantTokenMap = new HashMap<String, String>();

    //存放商家Token对应的商家登陆信息
    public static Map<String, MerchantRegist> loginMerchantMap = new HashMap<String, MerchantRegist>();


    /**
     * 生成ToKen
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public static String MerchantToken(String username, String password, MerchantRegist merchantRegist) {

        String token = userTokenMap.get(username);

        /**
         * 判断是否是新用户登陆
         * 是 生成token返回
         * 不是 删除旧的token 生成新的token返回
         */
        if (token == null) {
            // 先删除旧的存有用户信息的Token
            if(loginMerchantMap.get(MerchantTokenMap.get(username))!=null)
                loginMerchantMap.remove(MerchantTokenMap.get(username));
            //声成一个以用户名+密码+时间的 MD5 值作为 ToKen 存入 userTokenMap
            token = CustomMD5.passwordAndSalt(password, username + new Date().getTime(), 188);
            //将 token 存入 userTokenMap
            MerchantTokenMap.put(username, token);

            // 再将用户登陆的信息存入生成的 Token
            loginMerchantMap.put(token, merchantRegist);
            //返回生成的token
            return token;
        } else {
            //删除旧的token信息
            MerchantTokenMap.remove(username);
            loginMerchantMap.remove(token);
            //声成一个以用户名+密码+时间的 MD5 值作为 ToKen 存入 userTokenMap
            token = CustomMD5.passwordAndSalt(password, username + new Date().getTime(), 188);
            //将 token 存入 userTokenMap
            MerchantTokenMap.put(username, token);
            //将用户登陆的信息存入生成的 Token
            loginMerchantMap.put(token, merchantRegist);
            //返回生成的token
            return token;
        }
    }

    /**
     * 校验token是否有效 有效返回用户信息
     *
     * @param strToken
     * @return
     */
    public static MerchantRegist merchantToken(String strToken) {
        String token = MerchantTokenMap.get(strToken);
        if (token == null)
            return null;
        MerchantRegist merchantRegist = loginMerchantMap.get(token);
        return merchantRegist;
    }


}
