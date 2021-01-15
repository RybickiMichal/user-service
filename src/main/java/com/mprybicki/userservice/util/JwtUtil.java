package com.mprybicki.userservice.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    @Value("${token.secret.key}")
    private String secretKey;

    @Value("${token.validity.time.in.hours}")
    private String tokenValidityTimeInHours;

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (new Integer(tokenValidityTimeInHours) * 1000 * 60 * 60)))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }
}