package com.example.AuthenticationAndAuthorizationService.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JWTUtils {

        private SecretKey key;
        private static final long expTime = 86400000L;//24 hour

    public JWTUtils(){
        String secretString = "VGhpc2lzdmVyeXNlY3JldHRleHRyaWdodHRoZXJldG9rZWVwZXZlcnlvbmVhd2F5";
        byte[] keyBytes = Base64.getDecoder().decode(secretString);
        this.key = new SecretKeySpec(keyBytes, "HmacSHA256");

    }

    public String generateToken(UserDetails userDetails){
            return Jwts.builder()
                    .subject(userDetails.getUsername())
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + expTime))
                    .signWith(key)
                    .compact();
    }

    public String generateRefreshToken(HashMap<String, Objects> claims, UserDetails userDetails){
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expTime))
                .signWith(key)
                .compact();
    }

    public String ExtractUsername(String token){
        return ExtractClaims(token, Claims::getSubject);
    }

    private <T> T ExtractClaims(java.lang.String token, Function<Claims, T> claimsTFunction) {
        return claimsTFunction.apply(Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload());
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = ExtractUsername(token);
        return (username.equals(userDetails.getUsername()) && isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return ExtractClaims(token, Claims::getExpiration).before(new Date());
    }

}
