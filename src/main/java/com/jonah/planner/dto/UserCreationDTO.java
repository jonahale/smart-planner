package com.jonah.planner.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
public class UserCreationDTO {
    // data necessary to create a user
    @NotEmpty(message = "Name cannot be empty.")
    private String name;

    @NotEmpty(message = "Password cannot be empty.")
    private String password;
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
