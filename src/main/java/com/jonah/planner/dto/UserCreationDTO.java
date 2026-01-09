package com.jonah.planner.dto;

import com.jonah.planner.domain.Role;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserCreationDTO {
    // data necessary to create a user
    @NotEmpty(message = "Name cannot be empty.")
    private String name;

    @NotEmpty(message = "Password cannot be empty.")
    private String password;

    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
