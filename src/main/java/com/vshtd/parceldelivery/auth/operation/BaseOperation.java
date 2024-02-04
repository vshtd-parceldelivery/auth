package com.vshtd.parceldelivery.auth.operation;

import com.vshtd.parceldelivery.auth.model.entity.Profile;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class BaseOperation<REQ, RESP> implements Operation<REQ, RESP> {

    protected void preOperation(REQ req) {
    }

    protected void postOperation(REQ req) {
    }

    @Override
    public RESP process(REQ req) {
        preOperation(req);
        RESP resp = execute(req);
        postOperation(req);
        return resp;
    }

    protected void checkNoProfileException(Profile profile, String username) {
        if (Objects.isNull(profile)) {
            throw new RuntimeException("Such profile does not exist " + username);
        }
    }
}