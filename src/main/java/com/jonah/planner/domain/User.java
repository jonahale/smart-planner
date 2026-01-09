package com.jonah.planner.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Entity
public class User {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    private String password;

    @Getter
    @Setter
    private String name;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Role role;
}
