package com.vshtd.parceldelivery.auth.service;

import com.vshtd.parceldelivery.auth.model.internal.Jwt;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

public interface JwtService {

    String generatedJwt(Authentication authentication);

    Claims getClaims(String jwt);

    boolean isValidJwt(Jwt jwt);
}

