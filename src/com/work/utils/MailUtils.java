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

//�ʼ����͵Ĺ�����
public class MailUtils {
	//to ��˭���ʼ�
	//code �ʼ�������
    public static void sendMail(String to,String code) throws Exception{
    	//1.�������Ӷ������ӵ����������
    	Properties props = new Properties();
    	//props.setProperties("host",value);
    	//��ߵڶ�����������֤��Ϣ
    	//���session��mail��jar���µ�session
    	Session session = Session.getInstance(props,new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				//ͬ������û������������֤���Ӷ���¼�����������
				return new PasswordAuthentication("12454dd@1634.com","123");
			}
    		
    	});
    	//2�������ʼ����󣬴���һ���ʼ�������session
    	Message message = new MimeMessage(session);
    	//2.1���÷�����,ע��Ҫ���ַ���ת��һ����ַ����
    	message.setFrom(new InternetAddress("12454dd@1634.com"));
    	//2.2�����ռ���
    	message.setRecipient(RecipientType.TO,new InternetAddress(to) );
    	//2.3��������
    	message.setSubject("����Ǽ����ʼ�");
    	//2.4��������
    	message.setContent("<h1>����һ�⼤���ʼ��������������</h1><h3><a href = 'http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</h3>", code);
    	//3.����һ�⼤���ʼ�
    	Transport.send(message);
    }
}
