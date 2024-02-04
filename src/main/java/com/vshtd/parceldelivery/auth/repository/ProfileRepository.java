package com.vshtd.parceldelivery.auth.repository;

import com.vshtd.parceldelivery.auth.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query(value = "select p from Profile p where p.username = :username")
    Profile findByUsername(@Param(value = "username") String username);
}

