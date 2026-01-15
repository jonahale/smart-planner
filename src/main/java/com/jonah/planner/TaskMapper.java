package com.jonah.planner;

import com.jonah.planner.domain.Task;
import com.jonah.planner.dto.TaskRequestDTO;
import com.jonah.planner.dto.TaskResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskRequestDTO dto);

    TaskResponseDTO toResponseDto(Task task);

    List<TaskResponseDTO> toResponseDtoList(List<Task> task);

}
