package com.vshtd.parceldelivery.auth.service;

import com.vshtd.parceldelivery.auth.mapper.JwtMapper;
import com.vshtd.parceldelivery.auth.model.dto.JwtDTO;
import com.vshtd.parceldelivery.auth.model.dto.ProfileAuthDTO;
import com.vshtd.parceldelivery.auth.provider.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private JwtMapper jwtMapper;

    @Autowired
    private UsernamePasswordAuthenticationProvider authenticationProvider;

    @Override
    public JwtDTO auth(ProfileAuthDTO userAuth) {
        return jwtMapper.map(authenticationProvider.authenticate(userAuth.getUsername(), userAuth.getPassword()));
    }
}
