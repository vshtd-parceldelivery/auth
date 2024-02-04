package com.vshtd.parceldelivery.auth.mapper;

import com.vshtd.parceldelivery.auth.model.dto.ProfileRespDTO;
import com.vshtd.parceldelivery.auth.model.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileRespMapper implements Mapper<Profile, ProfileRespDTO> {

    @Override
    public ProfileRespDTO map(Profile profile) {
        return ProfileRespDTO.builder()
                .username(profile.getUsername())
                .role(profile.getRole())
                .build();
    }
}
