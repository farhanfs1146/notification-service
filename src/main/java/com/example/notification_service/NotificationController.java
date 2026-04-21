package com.example.notification_service;

import com.example.notification_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    // we will hit this API through employee-service using Feign-Client Approach for now
    private final EmailService emailService;

    @PostMapping("/birthday")
    public void sendBirthdayWish(
            @RequestParam String email,
            @RequestParam String employeeName
    ) {
        emailService.sendBirthdayEmail(email, employeeName);
    }

}
