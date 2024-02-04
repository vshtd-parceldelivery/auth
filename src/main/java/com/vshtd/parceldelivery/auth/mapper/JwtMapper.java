package com.vshtd.parceldelivery.auth.mapper;

import com.vshtd.parceldelivery.auth.model.dto.JwtDTO;
import org.springframework.stereotype.Component;

@Component
public class JwtMapper implements Mapper<String, JwtDTO> {

    @Override
    public JwtDTO map(String token) {
        return JwtDTO.builder()
                .token(token)
                .build();
    }
}
