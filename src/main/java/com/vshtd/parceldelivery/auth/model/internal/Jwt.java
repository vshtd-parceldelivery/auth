package com.vshtd.parceldelivery.auth.model.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Jwt implements Serializable {

    private String token;
}


