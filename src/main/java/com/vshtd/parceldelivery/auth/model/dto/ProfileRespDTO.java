package com.vshtd.parceldelivery.auth.model.dto;

import com.vshtd.parceldelivery.auth.model.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class ProfileRespDTO implements Serializable {

    private String username;
    private Role role;
}
