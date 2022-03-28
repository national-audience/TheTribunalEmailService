package io.github.nationalaudience.thetribunal.controller;

import io.github.nationalaudience.thetribunal.Mail;
import io.github.nationalaudience.thetribunal.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    public record EmailRequest(String to, String subject, String body) {
    }

    @Autowired
    EmailService emailService;

    @PostMapping("/followMessage")
    public void sendFollowMessage(@RequestBody EmailRequest request) {
        emailService.sendTestMessage(new Mail(request.to, request.subject, request.body));
    }

}
