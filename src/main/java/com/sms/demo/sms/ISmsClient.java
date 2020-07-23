package com.sms.demo.sms;

public interface ISmsClient {

    public void init();

    public abstract String getKey();

    public abstract String getSmsClientCfgPath();

    /**
     *
     * @param templateid
     * @param param
     * @param mobile
     * @param uid
     * @return
     */
    public abstract String sendSms(String templateid, String param, String mobile, String uid);

    /**
     *
     * @param templateid
     * @param param
     * @param mobile
     * @param uid
     * @return
     */
    public abstract String sendSmsBatch(String templateid, String param, String mobile, String uid);

    /**
     *
     * @param type
     * @param template_name
     * @param autograph
     * @param content
     * @return
     */
    public abstract String addSmsTemplate(String type, String template_name, String autograph, String content);

    /**
     *
     * @param templateid
     * @param page_num
     * @param page_size
     * @return
     */
    public abstract String getSmsTemplate(String templateid, String page_num, String page_size);

    /**
     *
     * @param templateid
     * @param type
     * @param template_name
     * @param autograph
     * @param content
     * @return
     */
    public abstract String editSmsTemplate(String templateid, String type, String template_name, String autograph, String content);

    /**
     *
     * @param templateid
     * @return
     */
    public abstract String deleterSmsTemplate(String templateid);

}