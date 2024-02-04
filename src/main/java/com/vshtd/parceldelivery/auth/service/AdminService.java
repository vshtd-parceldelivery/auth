package com.vshtd.parceldelivery.auth.service;

import com.vshtd.parceldelivery.auth.model.dto.ProfileRespDTO;

import java.util.List;

public interface AdminService {

    ProfileRespDTO get(String name);

    List<ProfileRespDTO> all();
}
