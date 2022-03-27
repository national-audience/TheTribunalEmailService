package io.github.nationalaudience.thetribunal.controller;

import io.github.nationalaudience.thetribunal.Mail;
import io.github.nationalaudience.thetribunal.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/followMessage")
    public void sendFollowMessage(@RequestBody List<String> messageData) {
        Mail mail = new Mail(messageData.get(0), messageData.get(1), messageData.get(2));
        emailService.sendTestMessage(mail);
    }

}
