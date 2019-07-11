package com.test.testApp.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendMailUtil {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.exmail.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息

        Session session = Session.getDefaultInstance(properties);
        Message message = new MimeMessage(session);

        try {
            Transport transport = session.getTransport();
            transport.connect("sql@bcpeople.com", "eifdPpt7");

            message.setFrom(new InternetAddress("sql@bcpeople.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("wangmingxu@bcpeople.com"));
            message.setSubject(MimeUtility.encodeText("测试邮件发送主题"));
            message.setContent("<b>你好啊</b>", "text/html; charset=utf-8");
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
