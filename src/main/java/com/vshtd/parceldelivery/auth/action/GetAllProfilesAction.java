package com.vshtd.parceldelivery.auth.action;

import com.vshtd.parceldelivery.auth.model.entity.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProfilesAction extends BaseAction<Void, List<Profile>> {

    @Override
    public List<Profile> execute(Void unused) {
        return profileRepository.findAll();
    }
}
