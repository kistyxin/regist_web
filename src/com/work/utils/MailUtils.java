package com.imooc.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//邮件发送的工具类
public class MailUtils {
	//to 给谁发邮件
	//code 邮件激活码
    public static void sendMail(String to,String code) throws Exception{
    	//1.创建连接对象，连接到邮箱服务器
    	Properties props = new Properties();
    	//props.setProperties("host",value);
    	//这边第二个参数是认证信息
    	//这个session是mail的jar包下的session
    	Session session = Session.getInstance(props,new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				//同过这个用户名密码进行验证，从而登录到邮箱服务器
				return new PasswordAuthentication("12454dd@1634.com","123");
			}
    		
    	});
    	//2。创建邮件对象，代表一封邮件，传入session
    	Message message = new MimeMessage(session);
    	//2.1设置发件人,注意要把字符串转成一个地址对象
    	message.setFrom(new InternetAddress("12454dd@1634.com"));
    	//2.2设置收件人
    	message.setRecipient(RecipientType.TO,new InternetAddress(to) );
    	//2.3设置主题
    	message.setSubject("这个是激活邮件");
    	//2.4设置正文
    	message.setContent("<h1>这是一封激活邮件，点击以下链接</h1><h3><a href = 'http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</h3>", code);
    	//3.发送一封激活邮件
    	Transport.send(message);
    }
}
