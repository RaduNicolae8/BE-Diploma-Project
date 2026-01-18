package com.diploma.project.config;

import com.diploma.project.auth.AuthRemoteService;
import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String JWT_COOKIE = "jwtCookie";
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final AuthRemoteService authRemoteService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURL().toString().contains("/public")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt, username;
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            filterChain.doFilter(request, response);
            return;
        }

        Optional<Cookie> optionalCookie = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(JWT_COOKIE))
                .findFirst();

        if (optionalCookie.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }

        Cookie cookie = optionalCookie.get();
        jwt = cookie.getValue();
        //username = jwtService.extractUsername(jwt);

        MarketplaceUserDTO user;

        try {
            user = authRemoteService.getUserFromCookie(jwt);
        } catch (Exception e) {
            // Invalid / expired token or Auth service unavailable
            filterChain.doFilter(request, response);
            return;
        }

        if (user == null ||
                user.getEmail() == null ||
                SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }


        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        user,                     // principal
                        null,                     // credentials (not needed)
                        user.getAuthorities()     // roles/authorities
                );

        authToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}
