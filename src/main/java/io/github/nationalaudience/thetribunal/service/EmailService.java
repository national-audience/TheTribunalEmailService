package io.github.nationalaudience.thetribunal.service;

import io.github.nationalaudience.thetribunal.Mail;
import io.github.nationalaudience.thetribunal.MailProperties;
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

    final MailProperties mailProperties;

    private final String user;
    private final String password;

    private final Session session;
    private final Transport transport;

    public EmailService(MailProperties mailProperties) throws MessagingException {
        this.mailProperties = mailProperties;

        user = mailProperties.getConfigValue("spring.mail.username");
        password = mailProperties.getConfigValue("spring.mail.password");

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.port", 587);

        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        session = Session.getDefaultInstance(properties);

        transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", user, password);
    }

    public void sendTestMessage(Mail mail) {
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
