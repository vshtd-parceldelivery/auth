package com.vshtd.parceldelivery.auth.operation;

import com.vshtd.parceldelivery.auth.action.GetProfileAction;
import com.vshtd.parceldelivery.auth.model.entity.Profile;
import com.vshtd.parceldelivery.auth.model.internal.UserCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoadUserOperation extends BaseOperation<String, UserDetails> {

    @Autowired
    private GetProfileAction getProfile;

    @Transactional(readOnly = true)
    @Override
    public UserDetails execute(String username) {
        Profile profile = getProfile.execute(username);
        checkNoProfileException(profile, username);
        return new UserCustom(profile);
    }
}
