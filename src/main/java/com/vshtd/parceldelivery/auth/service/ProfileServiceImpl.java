package com.vshtd.parceldelivery.auth.service;

import com.vshtd.parceldelivery.auth.model.mqo.CreateProfileMQO;
import com.vshtd.parceldelivery.auth.operation.CreateProfileOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private CreateProfileOperation createProfile;

    @Override
    public void createProfile(CreateProfileMQO req) {
        createProfile.process(req);
    }
}
