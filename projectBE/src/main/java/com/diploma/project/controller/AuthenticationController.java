package com.diploma.project.controller;

import com.diploma.project.auth.AuthRemoteService;
import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.exception.CustomException;
import com.diploma.project.security.AuthenticationRequest;
import com.diploma.project.security.RegisterRequest;
import com.diploma.project.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AuthRemoteService authRemoteService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authRemoteService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody AuthenticationRequest request, HttpServletResponse response) throws CustomException {
        Cookie cookie = authRemoteService.login(request);

        response.addCookie(cookie);

        return ResponseEntity.ok(true);
    }

    @GetMapping
    public ResponseEntity<MarketplaceUserDTO> getAuthenticatedUser(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return ResponseEntity.notFound().build();
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("jwtCookie")) {
                String token = cookie.getValue();
                return ResponseEntity.ok(authRemoteService.getUserFromCookie(token));
            }

        }
        return ResponseEntity.notFound().build();
    }
}