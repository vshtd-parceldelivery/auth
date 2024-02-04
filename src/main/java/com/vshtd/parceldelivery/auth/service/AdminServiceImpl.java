package com.vshtd.parceldelivery.auth.service;

import com.vshtd.parceldelivery.auth.model.dto.ProfileRespDTO;
import com.vshtd.parceldelivery.auth.operation.GetAllProfilesOperation;
import com.vshtd.parceldelivery.auth.operation.GetProfileOperation;
import com.vshtd.parceldelivery.auth.operation.LoadUserOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminServiceImpl implements UserDetailsService, AdminService {

    @Autowired
    private LoadUserOperation loadUser;

    @Autowired
    private GetProfileOperation getProfile;

    @Autowired
    private GetAllProfilesOperation getAllProfiles;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return loadUser.process(username);
    }

    @Override
    public ProfileRespDTO get(String username) {
        return getProfile.process(username);
    }

    @Override
    public List<ProfileRespDTO> all() {
        return getAllProfiles.process(null);
    }
}

