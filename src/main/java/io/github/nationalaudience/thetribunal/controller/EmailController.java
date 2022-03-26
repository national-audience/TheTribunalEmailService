package io.github.nationalaudience.thetribunal.controller;

import io.github.nationalaudience.thetribunal.email.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private record FollowMessageData(String user, String following) {
    }

    public final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/followMessage")
    public void sendFollowMessage(@RequestBody FollowMessageData messageData) {
        emailService.sendTestMessage("relegends00@gmail.com");
    }

}
