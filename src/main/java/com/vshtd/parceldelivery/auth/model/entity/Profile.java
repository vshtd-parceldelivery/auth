package com.vshtd.parceldelivery.auth.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "profile_seq", allocationSize = 1)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;
}

