package com.diploma.project.auth;

import com.diploma.project.auth.requests.AuthUserRequest;
import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.security.AuthenticationRequest;
import com.diploma.project.security.RegisterRequest;
import com.diploma.project.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthClient {

    private final WebClient authWebClient;


    public boolean registerRequest(RegisterRequest request) {
        return Boolean.TRUE.equals(authWebClient
                .post()
                .uri("/api/auth/register")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }

    public String loginUserRequest(AuthenticationRequest request){
        RestTemplate restTemplate = new RestTemplate();

        String url = AuthConstants.urlToAuthService + "/api/auth/login";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Set content type to JSON
        HttpEntity<AuthenticationRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );

        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getHeaders().get("Set-Cookie").get(0);
        }

        throw new RuntimeException("Error while logging in");
    }

    public Optional<MarketplaceUserDTO> getUserInfoRequest(AuthUserRequest request) {

        RestTemplate restTemplate = new RestTemplate();

        String url = AuthConstants.urlToAuthService + "/api/auth";

        HttpHeaders headers = new HttpHeaders();
        headers.add("jwtCookie", request.getJwtCookie());

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MarketplaceUserDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                MarketplaceUserDTO.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return Optional.ofNullable(response.getBody());
        }

        return Optional.empty();
    }
}
