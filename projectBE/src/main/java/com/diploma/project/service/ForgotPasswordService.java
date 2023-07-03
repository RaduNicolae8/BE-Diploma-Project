package com.diploma.project.service;

import com.diploma.project.dto.MarketplaceUserDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ForgotPasswordService {

    @Value("${resetPassword.url}")
    private String resetPasswordUrl;
    private final JavaMailSender javaMailSender;
    private final MarketplaceUserService marketplaceUserService;

    public ResponseEntity<Void> processForgotPasswordService(String email) {
        String token = UUID.randomUUID().toString();
        try {
            marketplaceUserService.updateResetPasswordToken(token, email);
            String resetPasswordLink = resetPasswordUrl + token;
            sendEmail(email, resetPasswordLink);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> processResetPasswordService(String token, String password) {
        MarketplaceUserDTO user = marketplaceUserService.findByResetPasswordToken(token);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            marketplaceUserService.updatePassword(user, password);
        }
        return ResponseEntity.ok().build();
    }

    public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String name = marketplaceUserService.findByUsername(recipientEmail).getFirstName();

        helper.setFrom("EasyService.helpdesk@gmail.com", "EasyService Marketplace Support");
        helper.setTo(recipientEmail);
        String subject = "Here's the link to reset your password";
        String content = "<p>Hello " + name + ",</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);
        helper.setText(content, true);
        javaMailSender.send(message);
    }
}
