package com.sms.demo.controller;

import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sms.demo.Constants;
import com.sms.demo.mapper.dao.TbUserMapper;
import com.sms.demo.mapper.dao.TbVipMapper;
import com.sms.demo.mapper.model.TbUser;
import com.sms.demo.mapper.model.TbVip;
import com.sms.demo.resp.CodeMsg;
import com.sms.demo.resp.Result;
import com.sms.demo.sms.ISmsClient;
import com.sms.demo.sms.SmsStrategy;
import com.sms.demo.util.BeanConvertUtils;
import com.sms.demo.vo.VipInfoVo;
import com.sms.demo.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Api(tags = "Api接口模块")
@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private SmsStrategy smsStrategy;

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbVipMapper tbVipMapper;

    @ApiOperation("登录获取用户信息")
    @GetMapping("login")
    @ResponseBody
    public Result<UserVo> login(HttpServletRequest req, @RequestParam(required = false) String mobile) {
        if(StrUtil.isBlank(mobile)) {
            return Result.error(CodeMsg.BIND_ERROR.fillArgs("手机号码不能为空!"));
        }
        String userAgent = req.getHeader("User-Agent");
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("id", 1);
        TbUser tbUser = tbUserMapper.selectOneByExample(example);
        UserVo vo = BeanConvertUtils.copyProperties(tbUser, UserVo.class);
        return Result.success(vo);
    }

    @ApiOperation("发送短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", defaultValue = "13121510595"),
    })
    @GetMapping("/sendSms")
    @ResponseBody
    public Result<Object> sendSms(@RequestParam(required = false) String mobile, HttpSession session) {
        if(StrUtil.isBlank(mobile)) {
            return Result.error(CodeMsg.BIND_ERROR.fillArgs("手机号码不能为空!"));
        }

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
        JSONObject result = JSONUtil.parseObj(reqClient.sendSms(tmplateid, param, mobile, ""));
        return Result.success(null);
    }

    @ApiOperation("获取商品信息列表")
    @GetMapping("/showVipList")
    @ResponseBody
    public Result<List<VipInfoVo>> showVipList() {
        List<VipInfoVo> vipList = new ArrayList<VipInfoVo>();
        List<TbVip> tbVips = tbVipMapper.selectAll();
        for (int i = 0; i < tbVips.size(); i++) {
            vipList.add(BeanConvertUtils.copyProperties(tbVips.get(i), VipInfoVo.class));
        }

        return Result.success(vipList);
    }

}
