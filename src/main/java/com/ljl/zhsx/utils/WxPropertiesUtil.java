package com.ljl.zhsx.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/8/4 11:57
 */
@Component
public class WxPropertiesUtil implements InitializingBean {

    @Value("${wxlogin.wx.appId}")
    private String appId;        //公众号标识

    @Value("${wxlogin.appSecret}")
    private String appSecret;    //公众号密码

    @Value("${wxlogin.server}")
    private String server;        //服务器域名地址，用于微信服务器回调。
    @Value("${wxlogin.qrCodeUrl}")
    private String qrCodeUrl;    //获取code接口
    @Value("${wxlogin.tokenUrl}")
    private String tokenUrl;    //获取token接口
    @Value("${wxlogin.openIdUrl}")
    private String openIdUrl;   //获取openid接口
    @Value("${wxlogin.userInfoUrl}")
    private String userInfoUrl;   //获取用户信息接口
    @Value("${wxlogin.token}")
    private String token;       //验证接口的标识

    public static String APP_ID;
    public static String APP_SECRET;
    public static String SERVER;
    public static String QR_CODE_URL;
    public static String TOKEN_URL;
    public static String OPENID_URL;
    public static String USERINFO_URL;
    public static String TOKEN;


    @Override
    public void afterPropertiesSet() throws Exception {
        APP_ID = this.appId;
        APP_SECRET = this.appSecret;
        SERVER = this.server;
        QR_CODE_URL = this.qrCodeUrl;
        TOKEN_URL = this.tokenUrl;
        OPENID_URL = this.openIdUrl;
        USERINFO_URL = this.userInfoUrl;
        TOKEN = this.token;
    }
}
