package com.jonah.planner;
import com.jonah.planner.domain.User;
import com.jonah.planner.dto.UserCreationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreationDTO userCreationDTO);

    UserCreationDTO toDto(User user);
    List<UserCreationDTO> toDTOList(List<User> users);
}
