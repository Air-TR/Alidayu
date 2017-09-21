package com.tr.alidayu.msg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.taobao.api.DefaultTaobaoClient;

/**
 * SMS配置类
 * 注：可修改阿里大于相关默认配置。
 * 
 * @author taorun
 * @date 2017年9月20日 下午3:01:56
 *
 */
@Configuration
public class MsgConfiguration {

	@Bean
	public DefaultTaobaoClient defaultTaobaoClient() {
		return new DefaultTaobaoClient(url, appkey, secret);
	}

	/**
	 * 阿里大于配置
	 */
	@Value(value = "${sms.alidayu.url}")
	private String url;
	@Value(value = "${sms.alidayu.appkey}")
	private String appkey;
	@Value(value = "${sms.alidayu.secret}")
	private String secret;

	/**
	 * 验证码有效时间
	 */
	@Value(value = "${sms.alidayu.verifyCodeExpiry}")
	private Integer verifyCodeExpiry;
	
	/**
	 * 验证码重新发送时间间隔
	 */
	@Value(value = "${sms.alidayu.verifyCodeRetry}")
	private Integer verifyCodeRetry;

	/**
	 * 同一IP地址当天发送次数限制
	 */
	@Value(value = "${sms.alidayu.verifyCodeAddressCount}")
	private Integer verifyCodeAddressCount;

	/**
	 * 同一手机号当天发送次数限制
	 */
	@Value(value = "${sms.alidayu.verifyCodeMobileCount}")
	private Integer verifyCodeMobileCount;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Integer getVerifyCodeExpiry() {
		return verifyCodeExpiry;
	}

	public Integer getVerifyCodeRetry() {
		return verifyCodeRetry;
	}

	public Integer getVerifyCodeAddressCount() {
		return verifyCodeAddressCount;
	}

	public Integer getVerifyCodeMobileCount() {
		return verifyCodeMobileCount;
	}

	public void setVerifyCodeExpiry(Integer verifyCodeExpiry) {
		this.verifyCodeExpiry = verifyCodeExpiry;
	}

	public void setVerifyCodeRetry(Integer verifyCodeRetry) {
		this.verifyCodeRetry = verifyCodeRetry;
	}

	public void setVerifyCodeAddressCount(Integer verifyCodeAddressCount) {
		this.verifyCodeAddressCount = verifyCodeAddressCount;
	}

	public void setVerifyCodeMobileCount(Integer verifyCodeMobileCount) {
		this.verifyCodeMobileCount = verifyCodeMobileCount;
	}
	
}
