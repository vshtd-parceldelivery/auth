package com.vshtd.parceldelivery.auth.provider;

import com.vshtd.parceldelivery.auth.service.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtServiceImpl jwtService;

    public String authenticate(String username, String password) throws AuthenticationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            return jwtService.generatedJwt(new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities()));
        } else {
            throw new BadCredentialsException("Bad credentials has been provided");
        }
    }
}

