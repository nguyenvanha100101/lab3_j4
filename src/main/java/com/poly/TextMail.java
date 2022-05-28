package com.poly;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class TextMail {
public static void main(String[] args) {
	Properties props = new Properties();
	props.setProperty("mail.smtp.auth","true");
	props.setProperty("mail.smtp.starttls.enable","true");
	props.setProperty("mail.smtp.host","smtp.gmail.com");
	props.setProperty("mail.smtp.port","587");
	props.setProperty("mail.smtp.ssl.trust","smtp.gmail.com");
	props.setProperty("mail.smtp.ssl.protocols","TLSv1.2");
	Session session = Session.getInstance(props, new Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		String username = "vanha100101@gmail.com";
		String password = "qdpiqlpfqgvgvnpr";
		return new PasswordAuthentication(username, password);
	}
	});
	MimeMessage email = new MimeMessage(session);
	try {
		email.setFrom(new InternetAddress("vanha100101@gmail.com") );
		email.setRecipient(RecipientType.TO,new InternetAddress("hanvpk02085@fpt.edu.vn"));
		email.setText("<h1>Kiểm tra gửi mail</h1>","utf-8","html");
		email.setSubject("kiểm thử");
		email.setReplyTo(email.getFrom());
		Transport.send(email);
		System.out.println("Gửi thành công!");
	} catch (Exception e) {
	e.printStackTrace();
	}
}
}
