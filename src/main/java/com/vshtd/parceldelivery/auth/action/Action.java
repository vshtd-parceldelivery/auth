package com.vshtd.parceldelivery.auth.action;

public interface Action<REQ, RESP> {

    RESP execute(REQ req);

}
