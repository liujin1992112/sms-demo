package com.sms.demo.listener;

import com.sms.demo.sms.SmsStrategy;
import com.sms.demo.sms.UCPaasReqClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 监听Spring应用启动完成
 */
@Configuration
@Order(-100)
public class ApplicationStartListener implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private SmsStrategy smsStrategy;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        smsStrategy.initSmsClient(UCPaasReqClient.class);
    }
}
