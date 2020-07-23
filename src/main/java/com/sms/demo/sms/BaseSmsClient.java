package com.sms.demo.sms;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.setting.dialect.Props;

public abstract class BaseSmsClient implements ISmsClient {

    protected Props props;

    /**
     * 初始化短信客户端
     */
    @Override
    public void init() {
        this.loadSmsClientCfg();
        this.initSmsClient();
    }

    /**
     * 具体执行短信客户端的初始化操作
     */
    protected void initSmsClient() {};

    protected void loadSmsClientCfg() {
        String path = this.getSmsClientCfgPath();
        ClassPathResource resource = new ClassPathResource(path);
        Props props = new Props();
        props.load(resource);
        this.props = props;
    }
}
