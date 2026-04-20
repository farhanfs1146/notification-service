package com.example.notification_service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    // we will hit this API through employee-service using Feign-Client Approach for now
    @PostMapping("/birthday")
    public void sendBirthdayWish(
            @RequestParam String email,
            @RequestParam String message
    ) {
        System.out.println("Sending email to: " + email);
        System.out.println("Message: " + message);
        // later: integrate email/SMS service
    }

}
