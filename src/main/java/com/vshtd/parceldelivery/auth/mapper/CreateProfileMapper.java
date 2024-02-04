package com.vshtd.parceldelivery.auth.mapper;

import com.vshtd.parceldelivery.auth.model.entity.Profile;
import com.vshtd.parceldelivery.auth.model.mqo.CreateProfileMQO;
import org.springframework.stereotype.Component;

@Component
public class CreateProfileMapper implements Mapper<CreateProfileMQO, Profile> {

    @Override
    public Profile map(CreateProfileMQO req) {
        return Profile.builder()
                .username(req.getUsername())
                .password(req.getPassword())
                .role(req.getRole())
                .build();
    }
}
