package io.github.nationalaudience.thetribunal.email;

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

    private final Session session;
    private final Transport transport;

    public EmailService() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.port", 587);

        properties.put("mail.smtp.user", user);
        properties.put("mail.smtp.clave", password);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        session = Session.getDefaultInstance(properties);

        transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", user, password);
    }

    public void sendTestMessage(String mail) {
        try {
            var message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipients(Message.RecipientType.TO, mail);
            message.setSubject("Patata");
            message.setText("Soy una patata");
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
