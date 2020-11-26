package com.example.shiyouge.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.config.UserConstantInterface;

import java.util.HashMap;
import java.util.Map;

public class WenXinTest {
    public static void main(String[] args) {
        String code = "001Nkn0w3rZdnV2Er21w36jNhX3Nkn0J";
        // 向微信服务器发送请求
        // 配置请求参数
        Map<String, String> param = new HashMap<>();
        param.put("appid", UserConstantInterface.WX_LOGIN_APPID);
        param.put("secret", UserConstantInterface.WX_LOGIN_SECRET);
        param.put("js_code", code);
        param.put("grant_type", UserConstantInterface.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult = HttpClientUtil.doGet(UserConstantInterface.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        System.out.println(jsonObject);
        // 获取参数返回
        String session_key = jsonObject.get("session_key").toString();
        String open_id = jsonObject.get("openid").toString();
        System.out.println("----------------");
        System.out.println(session_key);
        System.out.println(open_id);
    }
}
