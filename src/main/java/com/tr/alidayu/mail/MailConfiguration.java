package com.tr.alidayu.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfiguration {

	/**
	 * 阿里大于邮件配置
	 */
	@Value(value = "${mail.send.account}")
	private String account;

	@Value(value = "${mail.send.password}")
	private String password;

	@Value(value = "${mail.key.smtp}")
	private String keySmtp;

	@Value(value = "${mail.value.smtp}")
	private String valueSmtp;

	@Bean
	public Session session() {
//		ParamCheckUtils.notNull(new Object[] { account, password, keySmtp, valueSmtp },
//				new String[] { "account", "password", "keySmtp", "valueSmtp" });
		
		Properties props = System.getProperties();
		props.setProperty(keySmtp, valueSmtp);
		
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(account, password);
			}
		});
		session.setDebug(true);
		return session;
	}

	@Bean
	public MimeMessage mimeMessage() {
		return new MimeMessage(session());
	}
	
	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public String getKeySmtp() {
		return keySmtp;
	}

	public String getValueSmtp() {
		return valueSmtp;
	}

}
