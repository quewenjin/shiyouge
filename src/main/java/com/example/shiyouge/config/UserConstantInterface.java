package com.example.shiyouge.config;

public interface UserConstantInterface {
    // 请求的网址
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    // appid
    public static final String WX_LOGIN_APPID = "wx297ad8e730eb9834";
    // 密匙
    public static final String WX_LOGIN_SECRET = "00f7712b0d308464992af6580a21c0fa";
    // 固定参数
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";
}

