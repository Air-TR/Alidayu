package com.tr.alidayu.msg.enums;

/**
 * 阿里大于短信签名类型
 * 
 * @author taorun
 * @date 2017年9月20日 上午10:10:40
 *
 */
public enum SignName {

    GERON_FILLET("金轮针布");
	
    private String value;
    
	private SignName(String value) {
		this.value = value;
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
