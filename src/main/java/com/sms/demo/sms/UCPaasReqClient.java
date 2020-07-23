package com.sms.demo.sms;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.setting.dialect.Props;
import cn.hutool.setting.dialect.PropsUtil;
import org.springframework.stereotype.Component;

/**
 * 云之迅短信客户端
 */
@Component
public class UCPaasReqClient extends BaseSmsClient implements ISmsClient {


    private String appid;
    private String sid;
    private String token;
    private String prefixServerUrl;

    @Override
    protected void initSmsClient() {
        super.initSmsClient();


        /**
         * 初始化短信平台相关的信息
         */
        this.appid = this.props.getStr("appid");
        this.sid = this.props.getStr("sid");
        this.token = this.props.getStr("token");
        this.prefixServerUrl = this.props.getStr("prefixServerUrl");
    }

    @Override
    public String getKey() {
        return "ucpaas";
    }

    @Override
    public String getSmsClientCfgPath() {
        return "ucpass-sms-config.properties";
    }

    @Override
    public String sendSms(String templateid, String param, String mobile, String uid) {

        String url = this.prefixServerUrl + "/sendsms";
        JSONObject paramMap = JSONUtil.createObj();
        paramMap.set("sid", this.sid);
        paramMap.set("token", this.token);
        paramMap.set("appid", this.appid);
        paramMap.set("templateid", templateid);
        paramMap.set("param", param);
        paramMap.set("mobile", mobile);
        paramMap.set("uid", uid);

        return HttpUtil.post(url, paramMap.toString());
    }

    @Override
    public String sendSmsBatch(String templateid, String param, String mobile, String uid) {
        return null;
    }

    @Override
    public String addSmsTemplate(String type, String template_name, String autograph, String content) {
        return null;
    }

    @Override
    public String getSmsTemplate(String templateid, String page_num, String page_size) {
        return null;
    }

    @Override
    public String editSmsTemplate(String templateid, String type, String template_name, String autograph, String content) {
        return null;
    }

    @Override
    public String deleterSmsTemplate(String templateid) {
        return null;
    }
}
