package org.example.authservice.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.authservice.dtos.MarketplaceUserDTO;
import org.example.authservice.security.AuthenticationRequest;
import org.example.authservice.security.RegisterRequest;
import org.example.authservice.exceptions.CustomException;
import org.example.authservice.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AuthentificationController {

    private final AuthenticationService authenticationService;

    @GetMapping("/test")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("Test");
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody AuthenticationRequest request, HttpServletResponse response) throws CustomException {
        return ResponseEntity.ok(
                authenticationService.login(request, response
                ));
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
                return ResponseEntity.ok(authenticationService.getAuthenticatedUser(token));
            }

            return ResponseEntity.notFound().build();
        }
        return null;
    }
}