package com.tr.alidayu.msg;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.tr.alidayu.result.Result;

/**
 * 短信发送类
 * 
 * @author taorun
 * @date 2017年9月21日 下午3:41:24
 *
 */
@Service
public class MsgSender {
	
	@Autowired
	private TaobaoClient taobaoClient;
	
	/**
	 * 发送验证码短信
	 * 
	 * @param phoneNo 手机号码
	 * @param signName 签名名称
	 * @param templateCode 模板ID
	 * @return
	 */
	public Result<Object> sendMessage(String phoneNo, String signName, String templateCode) {
		/**
		 * 短信模板内容可配置项 如：${code}，${number}，${name} ...
		 */
		String code = "" + RandomUtils.nextInt(100000, 1000000); // 6位随机数验证码
		
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend(""); // 固定
		req.setSmsType("normal"); // 固定
		req.setSmsFreeSignName(signName);
		req.setSmsParamString("{\"code\":\"" + code + "\"}");
		req.setRecNum(phoneNo);
		req.setSmsTemplateCode(templateCode);
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = taobaoClient.execute(req);
			if (rsp.isSuccess()) {
				return Result.success();
			} else {
				return Result.fail();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail();
		}
	}

}
