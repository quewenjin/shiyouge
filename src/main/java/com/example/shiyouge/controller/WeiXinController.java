package com.example.shiyouge.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.bean.User;
import com.example.shiyouge.config.UserConstantInterface;
import com.example.shiyouge.service.UserService;
import com.example.shiyouge.utils.HttpClientUtil;
import com.example.shiyouge.utils.RandomUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.lang.Math;

@RestController
@RequestMapping(value = "/weixin")
public class WeiXinController {
    @Autowired
    UserService userService;

    /**
     * 微信用户登录
     * @param params 前台传的 code
     * @return 状态：succeed 或 wrong + session_key + open_id
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String weixinLogin(@RequestBody Map<String, Object> params) {
        String code = params.get("code").toString();
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
        // 获取参数返回的
        String session_key = jsonObject.get("session_key").toString();
        String open_id = jsonObject.get("openid").toString();
        // 根据返回的user实体类，判断用户是否是新用户，是的话，创建新的用户，信息存到数据库，返回 session_key 和 open_id
        JSONObject json = new JSONObject();
        User user = userService.getUserByUserId(open_id);
        if(user == null){
            // 添加到数据库
            String uid = RandomUIDUtil.getTheRandomUID();
            while (userService.getUserByUserId(uid) != null){//防用户ID重复
                uid = RandomUIDUtil.getTheRandomUID();
            }
            Boolean flag = userService.createUserByOpenId(uid, open_id);
            if(!flag){
                json.put("status", "wrong");
            } else {
                json.put("status", "succeed");
            }
        }
        // 封装返回小程序
        json.put("session_key", session_key);
        json.put("open_id", open_id);
        return json.toString();
    }
}
