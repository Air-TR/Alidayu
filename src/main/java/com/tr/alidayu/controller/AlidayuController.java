package com.tr.alidayu.controller;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.alidayu.mail.EmailSender;
import com.tr.alidayu.msg.MsgSender;
import com.tr.alidayu.msg.enums.SignName;
import com.tr.alidayu.msg.enums.Template;
import com.tr.alidayu.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Alidayu")
@RequestMapping("/alidyu")
@RestController
public class AlidayuController {
	
	@Autowired
	private MsgSender msgSender;
	
	@Autowired
    private EmailSender emailSender;

	/**
	 * 发送短信
	 * 
	 * @param phoneNo 手机号码
	 * @return
	 */
	@ApiOperation(value = "发送短信验证码")
	@GetMapping(value = "/sendMsg")
	public Result<Object> sendMsg(@RequestParam String phoneNo) {
		return msgSender.sendMessage(phoneNo, SignName.GERON_FILLET.getValue(), Template.GERON_FILLET_REGISTER_CODE.getCode());
	}

	/**
	 * 发送邮件
	 * 
	 * @param recipient 收件人
	 * @return
	 */
	@ApiOperation(value = "发送邮箱验证码")
	@GetMapping(value = "/sendEmail")
	public Result<Object> sendEmaill(@RequestParam String recipient) {
		String title = "邮件标题";
		String code = "" + RandomUtils.nextInt(100000, 1000000); // 前闭后开，生成6位随机数验证码
		String content = "验证码是：" + code + "。";
		return emailSender.sendEmail(title, content, recipient, null);
	}

}
