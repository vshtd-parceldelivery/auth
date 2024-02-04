package com.vshtd.parceldelivery.auth.service;

import com.vshtd.parceldelivery.auth.model.dto.JwtDTO;
import com.vshtd.parceldelivery.auth.model.dto.ProfileAuthDTO;

public interface AuthenticationService {

    JwtDTO auth(ProfileAuthDTO userAuth);
}
