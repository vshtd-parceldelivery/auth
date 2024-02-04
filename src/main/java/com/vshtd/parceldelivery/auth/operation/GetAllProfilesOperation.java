package com.vshtd.parceldelivery.auth.operation;

import com.vshtd.parceldelivery.auth.action.GetAllProfilesAction;
import com.vshtd.parceldelivery.auth.mapper.ProfileRespMapper;
import com.vshtd.parceldelivery.auth.model.dto.ProfileRespDTO;
import com.vshtd.parceldelivery.auth.model.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllProfilesOperation extends BaseOperation<Void, List<ProfileRespDTO>> {

    @Autowired
    private GetAllProfilesAction getAllProfiles;

    @Autowired
    private ProfileRespMapper profileRespMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ProfileRespDTO> execute(Void unused) {
        List<Profile> profiles = getAllProfiles.execute(unused);
        return profiles.stream()
                .map(profile -> profileRespMapper.map(profile))
                .collect(Collectors.toList());
    }
}
