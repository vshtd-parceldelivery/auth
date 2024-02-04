package com.vshtd.parceldelivery.auth.operation;

import com.vshtd.parceldelivery.auth.action.CreateProfileAction;
import com.vshtd.parceldelivery.auth.model.mqo.CreateProfileMQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateProfileOperation extends BaseOperation<CreateProfileMQO, Void> {

    @Autowired
    private CreateProfileAction createProfile;

    @Transactional
    @Override
    public Void execute(CreateProfileMQO req) {
        createProfile.execute(req);
        return null;
    }
}
