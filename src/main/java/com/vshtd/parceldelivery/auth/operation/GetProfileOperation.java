package com.vshtd.parceldelivery.auth.operation;

import com.vshtd.parceldelivery.auth.action.GetProfileAction;
import com.vshtd.parceldelivery.auth.mapper.ProfileRespMapper;
import com.vshtd.parceldelivery.auth.model.dto.ProfileRespDTO;
import com.vshtd.parceldelivery.auth.model.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetProfileOperation extends BaseOperation<String, ProfileRespDTO> {

    @Autowired
    private GetProfileAction getProfile;

    @Autowired
    private ProfileRespMapper profileRespMapper;

    @Transactional(readOnly = true)
    @Override
    public ProfileRespDTO execute(String username) {
        Profile profile = getProfile.execute(username);
        checkNoProfileException(profile, username);
        return profileRespMapper.map(profile);
    }
}
