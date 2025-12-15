package org.example.authservice.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.authservice.dtos.MarketplaceUserDTO;
import org.example.authservice.exceptions.CustomException;
import org.example.authservice.security.AuthenticationRequest;
import org.example.authservice.security.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final MarketplaceUserService marketplaceUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public Boolean register(RegisterRequest request) {
        log.info("Registering request {}", request);
        MarketplaceUserDTO marketplaceUserDTO = new MarketplaceUserDTO(
                null,
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getFirstName(),
                request.getLastName(),
                request.getCountry(),
                request.getPhoneNumber(),
                request.getDescription(),
                request.getImg(),
                request.getIsSeller(),
                roleService.findById(request.getRoleId()),
                null,
                request.getLanguages()
        );
        marketplaceUserService.save(marketplaceUserDTO);
        return true;

    }

    public Boolean login(AuthenticationRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            MarketplaceUserDTO marketplaceUserDTO = marketplaceUserService.findByUsername(request.getUsername());
            Cookie cookie = jwtService.generateJwtCookie(marketplaceUserDTO);

            response.addCookie(cookie);
            return true;
        } catch (AuthenticationException ex) {
            log.error("User not logged in");
            throw new CustomException("Bad username or password", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
    }

    public MarketplaceUserDTO getAuthenticatedUser(String token) {
        return jwtService.getAuthenticatedUser(token);
    }

}
