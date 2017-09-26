package com.tr.alidayu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.alidayu.msg.MsgSender;
import com.tr.alidayu.msg.enums.SignName;
import com.tr.alidayu.msg.enums.Template;
import com.tr.alidayu.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Msg")
@RestController
public class MsgController {
	
	@Autowired
	private MsgSender msgSender;

	/**
	 * 发送短信
	 * 
	 * @param phoneNo 手机号码
	 * @return
	 */
	@ApiOperation(value = "阿里大于发送短信")
	@GetMapping(value = "/sendMsg")
	public Result<Object> sendMsg(@RequestParam String phoneNo) {
		return msgSender.sendMessage(phoneNo, SignName.GERON_FILLET.getValue(), Template.GERON_FILLET_REGISTER_CODE.getCode());
	}

}
