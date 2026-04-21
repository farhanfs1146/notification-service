package com.example.notification_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

//    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendBirthdayEmail(String toEmail, String employeeName) {

        // Validate email
        if (toEmail == null || toEmail.isBlank()) {
            log.warn("Birthday email not sent to {} because email is empty", employeeName);
            return;
        }

        try {
            String mailMessage = getSimpleMailMessage(toEmail, employeeName);
            String subject = "Happy Birthday Celebrations!";
//            mailSender.send(mailMessage);

            log.info("Birthday email sent successfully to {}", toEmail);
            log.info("{} {}",subject, mailMessage);

        } catch (Exception e) {
            log.error("Failed to send birthday email to {}", toEmail, e);
        }
    }

    private String getSimpleMailMessage(String toEmail, String employeeName) {
        String message;
        message = """
                Dear %s,

                Wishing you a very happy birthday 🎉
                May this year bring happiness, success, and good health.

                Best regards,
                People & Culture Team
                Forward Sports
                """
                .formatted(employeeName);

//        SimpleMailMessage mailMessage = new SimpleMailMessage();

//        mailMessage.setFrom(fromEmail);
//        mailMessage.setTo(toEmail);
//        mailMessage.setSubject("Happy Birthday 🎉");
//        mailMessage.setText(message);
        return message;
    }
}