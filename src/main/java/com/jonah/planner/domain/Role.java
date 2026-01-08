package com.jonah.planner.domain;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Role {

    private String id;
    private String name;
}
