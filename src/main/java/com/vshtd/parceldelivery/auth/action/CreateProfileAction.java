package com.vshtd.parceldelivery.auth.action;

import com.vshtd.parceldelivery.auth.mapper.CreateProfileMapper;
import com.vshtd.parceldelivery.auth.model.entity.Profile;
import com.vshtd.parceldelivery.auth.model.mqo.CreateProfileMQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProfileAction extends BaseAction<CreateProfileMQO, Void> {

    @Autowired
    private CreateProfileMapper createProfileMapper;

    @Override
    public Void execute(CreateProfileMQO req) {
        Profile profile = createProfileMapper.map(req);
        profileRepository.save(profile);
        return null;
    }
}
