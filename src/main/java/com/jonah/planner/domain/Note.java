package com.jonah.planner.domain;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Note {

    @Getter
    private Long id;

    @Getter
    @Setter
    String title;

    @Getter
    @Setter
    String content;
}
