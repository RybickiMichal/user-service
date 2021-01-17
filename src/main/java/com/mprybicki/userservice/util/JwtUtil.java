package com.mprybicki.userservice.util;

import com.mprybicki.userservice.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    private UserRepository userRepository;

    @Value("${token.secret.key}")
    private String secretKey;

    @Value("${token.validity.time.in.hours}")
    private String tokenValidityTimeInHours;

    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        userRepository.findByUserName(username).getRoles().forEach(role -> {
            claims.put(role,"");
        });
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (new Integer(tokenValidityTimeInHours) * 1000 * 60 * 60)))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }
}