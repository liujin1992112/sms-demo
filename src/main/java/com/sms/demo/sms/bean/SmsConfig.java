package com.sms.demo.sms.bean;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value={"classpath:ucpass-sms-config.properties"})
@Component
public class SmsConfig {
    private String appid;
    private String sid;
    private String token;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SmsConfig{" +
                "appid='" + appid + '\'' +
                ", sid='" + sid + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
