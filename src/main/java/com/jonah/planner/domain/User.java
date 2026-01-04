package com.jonah.planner.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id
    private long id;
    private String password;
    private String name;
    private String email;
    private List<Role> roles;
}
