package com.diploma.project.controller;

import com.diploma.project.service.ForgotPasswordService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class ForgotPasswordController {

    private final ForgotPasswordService forgotPassswordService;

    @PostMapping("/forgot_password")
    public ResponseEntity<Void> processForgotPassword(HttpServletRequest request) {
        String email = request.getParameter("email");
        return forgotPassswordService.processForgotPasswordService(email);
    }

    @PostMapping("/reset_password")
    public ResponseEntity<Void> processResetPassword(HttpServletRequest request) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        return forgotPassswordService.processResetPasswordService(token, password);
    }

}
