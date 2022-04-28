package io.github.nationalaudience.thetribunal.service;

import io.github.nationalaudience.thetribunal.Mail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    @Value("${email.user}")
    private String user;

    @Value("${email.password}")
    private String password;

    private final Session session;
    private Transport transport;


    public EmailService() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        session = Session.getDefaultInstance(properties);
    }

    public void sendTestMessage(Mail mail) {
        if (transport != null) {
            try {
                transport = session.getTransport("smtp");
                System.out.printf(user);
                System.out.printf(password);
                transport.connect("smtp.gmail.com", user, password);
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
        }

        try {
            var message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipients(Message.RecipientType.TO, mail.getEmailAddress());
            message.setSubject(mail.getEmailSubject());
            message.setText(mail.getEmailBody());
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
