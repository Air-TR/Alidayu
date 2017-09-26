package com.tr.alidayu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.alidayu.mail.MailSender;
import com.tr.alidayu.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Mail")
@RestController
public class MailController {
	
	@Autowired
    private MailSender mailSender;

	/**
	 * 发送邮件
	 * 
	 * @param recipient 收件人
	 * @return
	 */
	@ApiOperation(value = "java发送邮件")
	@GetMapping(value = "/sendEmail")
	public Result<Object> sendEmaill(@RequestParam String recipient) {
		String title = "邮件标题";
		String content = "邮件内容"; // 内容中可配置验证码等信息
		return mailSender.sendEmail(title, content, recipient, null);
	}

}
