package com.sms.demo.controller;

import cn.hutool.captcha.generator.RandomGenerator;
import com.sms.demo.Constants;
import com.sms.demo.mapper.dao.TbUserMapper;
import com.sms.demo.mapper.model.TbUser;
import com.sms.demo.resp.Result;
import com.sms.demo.sms.ISmsClient;
import com.sms.demo.sms.SmsStrategy;
import com.sms.demo.util.BeanConvertUtils;
import com.sms.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

@RestController
@RequestMapping("api")
public class Api {

    @Autowired
    private SmsStrategy smsStrategy;

    @Autowired
    private TbUserMapper tbUserMapper;

    @GetMapping("login")
    @ResponseBody
    public Result<UserVo> login() {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("id", 1);
        TbUser tbUser = tbUserMapper.selectOneByExample(example);
        UserVo vo = BeanConvertUtils.copyProperties(tbUser, UserVo.class);
        return Result.success(vo);
    }

    @RequestMapping("/sendSms")
    @ResponseBody
    public String sendSms(@RequestParam String mobile, HttpSession session) {

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
        }, Constants.VERIFY_CODE_INVALIDATE_TIME * 1000L);

        String tmplateid = "557706";

        ISmsClient reqClient = smsStrategy.getSmsClient();
        return reqClient.sendSms(tmplateid, param, mobile, "");
    }


}
