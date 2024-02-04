package com.vshtd.parceldelivery.auth.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class JwtDTO implements Serializable {

    private String token;
}
