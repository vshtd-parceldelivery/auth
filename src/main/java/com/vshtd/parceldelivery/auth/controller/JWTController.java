package com.vshtd.parceldelivery.auth.controller;

import com.vshtd.parceldelivery.auth.model.dto.JwtDTO;
import com.vshtd.parceldelivery.auth.model.dto.ProfileAuthDTO;
import com.vshtd.parceldelivery.auth.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/jwt")
@Tag(name = "Jwt", description = "jwt API")
public class JWTController {

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/authenticate")
    @Operation(summary = "auth and get token")
    public JwtDTO auth(@RequestBody ProfileAuthDTO userAuth) {
        return authService.auth(userAuth);
    }
}
