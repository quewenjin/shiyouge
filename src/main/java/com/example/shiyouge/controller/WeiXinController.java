package com.example.shiyouge.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shiyouge.bean.User;
import com.example.shiyouge.config.UserConstantInterface;
import com.example.shiyouge.service.UserService;
import com.example.shiyouge.utils.HttpClientUtil;
import com.example.shiyouge.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/weixin")
public class WeiXinController {
    @Autowired
    UserService userService;

    /**
     * 微信用户登录
     * @param params 前台传的 code
     * @return 状态：succeed 或 wrong + session_key + 用户ID + 宿舍ID
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
        // 获取参数返回
        String session_key = jsonObject.get("session_key").toString();
        String open_id = jsonObject.get("openid").toString();
//        JSONObject json = new JSONObject();
//        json.put("session_key", session_key);
//        json.put("openid", open_id);
        // 根据返回的user实体类，判断用户是否是新用户，是的话，创建新的用户，信息存到数据库，返回 session_key 和 open_id
        JSONObject json = new JSONObject();
        //用open_id查询用户
        User user = userService.getUserByOpenId(open_id);
        if(user == null){
            // 添加到数据库
            String theUid = RandomUtil.getTheRandomUID();
            while (userService.getUserByUserId(theUid) != null){//防用户ID重复
                theUid = RandomUtil.getTheRandomUID();
            }
            //创建用户
            Boolean flag = userService.createUserByOpenId(theUid, open_id);
            if(!flag){
                json.put("status", "wrong");
            } else {
                //随机头像
                int theHeadNum = RandomUtil.randomZeroToThree();
                String theHead = "https://pic.downk.cc/item/5ec11c50c2a9a83be54e84c8.jpg";//默认头像
                if (theHeadNum == 0){
                    theHead = "https://pic.downk.cc/item/5fbe44afb18d627113a4acaa.png";//headimg1
                } else if (theHeadNum == 1){
                    theHead = "https://pic.downk.cc/item/5fbe44afb18d627113a4acaa.png";//headimg2
                } else if (theHeadNum == 2){
                    theHead = "https://pic.downk.cc/item/5fbe44afb18d627113a4acaa.png";//headimg3
                } else if (theHeadNum == 3){
                    theHead = "https://pic.downk.cc/item/5fbe44afb18d627113a4acaa.png";//headimg4
                }
                //设置头像
                userService.setPhotoByUserId(theUid, theHead);
                //其他信息
                json.put("userId", theUid);
                json.put("dormitoryId", userService.getDormitoryIDByUserId(theUid));
                json.put("status", "succeed");
            }
        } else {
            json.put("userId", user.getUserId());
            json.put("dormitoryId", user.getUserDormitoryId());
        }
        // 封装返回小程序
        json.put("session_key", session_key);
        return json.toString();
    }
}
