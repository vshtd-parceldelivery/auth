package com.vshtd.parceldelivery.auth.service;

import com.vshtd.parceldelivery.auth.model.entity.Profile;
import com.vshtd.parceldelivery.auth.model.internal.Jwt;
import com.vshtd.parceldelivery.auth.repository.ProfileRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.signing.key}")
    private String signingKey;

    @Value("${jwt.key.expiration}")
    private Long jwtExpiration;

    private SecretKey key;

    @Autowired
    private ProfileRepository profileRepository;

    private SecretKey generatedSecretKey() {
        if (key == null) {
            key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
        }
        return key;
    }

    @Override
    public String generatedJwt(Authentication authentication) {
        return Jwts.builder()
                .setClaims(
                        Map.of(
                                ClaimField.USERNAME, authentication.getName(),
                                ClaimField.ROLE, authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())))
                .setExpiration(new Date(new Date().getTime() + jwtExpiration))
                .setSubject(authentication.getName())
                .signWith(generatedSecretKey())
                .compact();
    }

    @Override
    public Claims getClaims(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(generatedSecretKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    @Override
    public boolean isValidJwt(Jwt jwt) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(generatedSecretKey())
                .build()
                .parseClaimsJws(jwt.getToken())
                .getBody();

        Profile profile = profileRepository.findByUsername(String.valueOf(claims.get(ClaimField.USERNAME)));
        return claims.getExpiration().after(new Date()) && Objects.nonNull(profile);
    }
}

