package com.tr.alidayu.msg.enums;

/**
 * 阿里大于短信模板
 * 
 * @author taorun
 * @date 2017年9月20日 上午10:12:19
 *
 */
public enum Template {
	
	/**
	 * 尊敬的用户，您正在注册成为金轮针布企业用户，您的验证码是${code}，5分钟内输入有效。如非本人操作请忽略本短信。
	 */
	GERON_FILLET_REGISTER_CODE("SMS_97815028", "金轮针布注册验证码");
	
    private String code;

    private String value;

    private Template(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * @return 返回 code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param 对code进行赋值
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return 返回 value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param 对value进行赋值
     */
    public void setValue(String value) {
        this.value = value;
    }
    
}
