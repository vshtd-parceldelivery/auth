package com.vshtd.parceldelivery.auth.operation;

public interface Operation<REQ, RESP> {

    RESP execute(REQ req);

    RESP process(REQ req);

}
