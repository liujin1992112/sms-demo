package com.sms.demo.controller;

import cn.hutool.captcha.generator.RandomGenerator;
import com.sms.demo.Constants;
import com.sms.demo.sms.ISmsClient;
import com.sms.demo.sms.SmsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

@RestController
@RequestMapping("api")
public class Api {

    @Autowired
    private SmsStrategy smsStrategy;

    @RequestMapping("/index")
    public String index() {
        return "hello world!~";
    }

    @RequestMapping("/sendSms")
    @ResponseBody
    public String sendSms(HttpServletRequest req, HttpSession session) {
        String mobile = req.getParameter("mobile");

        //生成四位的验证码
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        String verifyCode = randomGenerator.generate();

        //构造参数
        String param = String.format("%s,%s", verifyCode, Constants.VERIFY_CODE_INVALIDATE_TIME);

        //将验证码缓存到session中
        session.setAttribute(Constants.VERIFY_CODE, Constants.VERIFY_CODE_INVALIDATE_TIME);

        //指定时间失效
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                session.removeAttribute(Constants.VERIFY_CODE);
                timer.cancel();
            }
        }, Constants.VERIFY_CODE_INVALIDATE_TIME);

        String tmplateid = "557706";

        ISmsClient reqClient = smsStrategy.getSmsClient();
        return reqClient.sendSms(tmplateid, param, mobile, "");
    }


}
