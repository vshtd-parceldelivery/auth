package com.vshtd.parceldelivery.auth.mapper;

public interface Mapper<FROM, TO> {

    TO map(FROM value);
}
