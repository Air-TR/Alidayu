package com.tr.alidayu.mail;

import java.util.List;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.alidayu.result.Result;

/**
 * 邮件发送类
 * 
 * @author taorun
 * @date 2017年9月21日 下午3:40:59
 *
 */
@Service
public class MailSender {

    public static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    @Autowired
    private MimeMessage message;

    @Autowired
    private MailConfiguration mailConfiguration;
    
    @Autowired
    private Session session;

    /**
     * 发送邮件
     * 
     * @param title 		邮件标题
     * @param content 	邮件内容
     * @param recipient	收件人
     * @param mailCC		抄送人
     */
    public Result<Object> sendEmail(String title, String content, String recipient, List<String> mailCC) {
        try {
            // 发件人
            InternetAddress from = new InternetAddress(mailConfiguration.getAccount());
            message.setFrom(from);
            // 收件人
            InternetAddress to = new InternetAddress(recipient);
            message.setRecipient(Message.RecipientType.TO, to);
            //TODO  有什么用
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress("2783944613@qq.com"));
            // 邮件标题
            message.setSubject(title);
            // 邮件内容,也可以使纯文本"text/plain"
            message.setContent(content, "text/html;charset=GBK");
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            // smtp验证，即用来发送邮件的邮箱账户和密码
            transport.connect(mailConfiguration.getValueSmtp(), mailConfiguration.getAccount(), mailConfiguration.getPassword());
            // 发送
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail();
        }
    }

}
