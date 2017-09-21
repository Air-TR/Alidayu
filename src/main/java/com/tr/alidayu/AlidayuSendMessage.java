package com.tr.alidayu;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 阿里大于发送短信
 * 
 * @author taorun
 * @date 2017年9月20日 下午4:12:30
 *
 */
public class AlidayuSendMessage {

	public static void main(String[] args) {
		sendMobileCode("17751451838"); // 13401443201
	}

	public static void sendMobileCode(String phoneNumber) {
		String rusult = null;
		// 官网URL
		String url = "http://gw.api.taobao.com/router/rest";
		// 成为开发者，创建应用后系统自动生成的appkey和secret
		String appkey = "23460920";
		String secret = "d5e33d69658e4bca7812ac7be61a1761";
		TaobaoClient taobaoClient = new DefaultTaobaoClient(url, appkey, secret);
		// 验证码
		String code = "520999";
		String product = "金轮针布";
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend(""); // 固定
		req.setSmsType("normal"); // 固定
		req.setSmsFreeSignName("金轮针布");
		req.setSmsParamString("{\"code\":\"" + code + "\",\"product\":\"" + product + "\"}");
		req.setRecNum(phoneNumber);
		req.setSmsTemplateCode("SMS_97815028");
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = taobaoClient.execute(req);
			System.out.println(rsp.getBody());
			System.out.println("============================");
			rusult = rsp.getSubMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(rusult);
	}

}
