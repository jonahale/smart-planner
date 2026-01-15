package com.jonah.planner;
import com.jonah.planner.domain.Role;
import com.jonah.planner.domain.User;
import com.jonah.planner.dto.UserCreationDTO;
import com.jonah.planner.dto.UserResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreationDTO userCreationDTO);

    UserCreationDTO toResponseDto(User user);

    List<UserResponseDTO> toResponseDtoList(List<User> users);

    // Converts Role enum to its String representation (ADMIN -> "ADMIN")
    default String map(Role role) {
        return role.name();
    }

    // Converts String value to Role enum ("ADMIN -> Role.ADMIN)
    default Role map(String role) {
        return Role.valueOf(role);
    }

}
