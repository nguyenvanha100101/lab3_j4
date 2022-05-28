package com.poly;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class SendMailServlet
 */
@MultipartConfig
@WebServlet({ "/mail/form", "/mail/send" })
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/sendmail/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "vanha100101@gmail.com";
				String password = "qdpiqlpfqgvgvnpr";
				return new PasswordAuthentication(username, password);
			}
		});

		Part attachFile = request.getPart("attach");
		String path = "doc" + attachFile.getSubmittedFileName();
		String filename = request.getServletContext().getRealPath(path);
		attachFile.write(filename);

		MimeMessage mime = new MimeMessage(session);
		try {
			Multipart mailmultipart = new MimeMultipart();

			MimeBodyPart bodytext = new MimeBodyPart();
			bodytext.setText(request.getParameter("body"), "utf-8", "html");

			MimeBodyPart bodyfile = new MimeBodyPart();
			bodyfile.setDataHandler(new DataHandler(new FileDataSource(new File(filename))));
			bodyfile.setFileName(attachFile.getSubmittedFileName());

			mailmultipart.addBodyPart(bodytext);
			mailmultipart.addBodyPart(bodyfile);

			mime.setFrom(new InternetAddress("from"));
			mime.setRecipients(Message.RecipientType.TO, request.getParameter("to"));
			mime.setSubject(request.getParameter("subject"), "utf-8");
			mime.setReplyTo(mime.getFrom());
			mime.setContent(mailmultipart);

			Transport.send(mime);
			request.setAttribute("message", "Gửi mail thành công");
			request.getRequestDispatcher("/views/sendmail/form.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
