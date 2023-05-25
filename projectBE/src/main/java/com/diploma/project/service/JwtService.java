package com.diploma.project.service;

import com.diploma.project.dto.MarketplaceUserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String JWT_COOKIE = "jwtCookie";

    private final MarketplaceUserService marketplaceUserService;
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.cookie-age}")
    private int cookieAge;

    public MarketplaceUserDTO getAuthenticatedUser(String token){
        String username = extractUsername(token);
        MarketplaceUserDTO user = marketplaceUserService.findByUsername(username);
        return user;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Cookie generateJwtCookie(UserDetails userDetails) {
        String jwtToken = generateToken(userDetails);
        Cookie jwtCookie = new Cookie(JWT_COOKIE, jwtToken);
        jwtCookie.setDomain("localhost");
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(cookieAge);
        jwtCookie.setHttpOnly(true);
        return jwtCookie;
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        List<String> roles = new ArrayList<>();
        Map<String, Object> rolesClaim = new HashMap<>();
        userDetails.getAuthorities().forEach(a -> roles.add(a.getAuthority()));
        rolesClaim.put("roles", roles);
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // valid for 1 hour
                .signWith(getSingInkey(), SignatureAlgorithm.HS256)
                .addClaims(rolesClaim)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSingInkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSingInkey() {
        byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }
}
