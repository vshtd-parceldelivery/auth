package com.vshtd.parceldelivery.auth.action;

import com.vshtd.parceldelivery.auth.model.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class GetProfileAction extends BaseAction<String, Profile> {

    @Override
    public Profile execute(String username) {
        return profileRepository.findByUsername(username);
    }
}
