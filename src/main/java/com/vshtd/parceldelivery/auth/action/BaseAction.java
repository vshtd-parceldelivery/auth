package com.vshtd.parceldelivery.auth.action;

import com.vshtd.parceldelivery.auth.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseAction<REQ, RESP> implements Action<REQ, RESP> {

    @Autowired
    protected ProfileRepository profileRepository;
}
