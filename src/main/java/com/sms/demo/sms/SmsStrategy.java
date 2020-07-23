package com.sms.demo.sms;

import org.springframework.stereotype.Component;

@Component
public class SmsStrategy {

    private ISmsClient smsClient;

    public ISmsClient getSmsClient() {
        return smsClient;
    }

    /**
     * 初始化短信发送客户端
     * @param clazz
     */
    public void initSmsClient(Class<? extends ISmsClient> clazz) {
        try {
            smsClient = clazz.newInstance();
            smsClient.init();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
