package com.diploma.project.auth;

import com.diploma.project.auth.requests.AuthUserRequest;
import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.mapper.GenericMapper;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.security.AuthenticationRequest;
import com.diploma.project.security.RegisterRequest;
import com.diploma.project.service.JwtService;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthRemoteService {

    private final AuthClient authClient;
    private final JwtService jwtService;

    public Boolean register(RegisterRequest request){

        if(authClient.registerRequest(request)){
            return true;
        }

        throw new RuntimeException("Registration failed");
    }

    public Cookie login(AuthenticationRequest request){
        String cookieString = authClient.loginUserRequest(request);

        String jwtToken = cookieString.substring(cookieString.indexOf("=") + 1, cookieString.indexOf(";"));

        Cookie cookie = jwtService.generateJwtCookie(jwtToken);

        return cookie;
    }

    public MarketplaceUserDTO getUserFromCookie(String jwtToken){
        Optional<MarketplaceUserDTO> user = authClient.getUserInfoRequest(new AuthUserRequest(jwtToken));

        if (user.isEmpty()){
            throw new RuntimeException("This EasyService user does not exist!");
        }

        return user.get();
    }
}
