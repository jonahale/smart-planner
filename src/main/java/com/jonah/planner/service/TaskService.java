package com.jonah.planner.service;

import com.jonah.planner.TaskMapper;
import com.jonah.planner.domain.Task;
import com.jonah.planner.dto.TaskRequestDTO;
import com.jonah.planner.dto.TaskResponseDTO;
import com.jonah.planner.exception.TaskNotFoundException;
import com.jonah.planner.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskResponseDTO> getTasks() {
        return taskMapper.toResponseDtoList(taskRepository.findAll());
    }

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = taskMapper.toEntity(taskRequestDTO);
        return taskMapper.toResponseDto(taskRepository.save(task));
    }

    public TaskResponseDTO getTaskByID(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return taskMapper.toResponseDto(task);
    }

    public List<TaskResponseDTO> searchTaskByTitle(String title) {
        String taskSearch;

        if (title == null) {
            taskSearch = "";
        } else {
            taskSearch = title.trim();
        }

        if (taskSearch.isEmpty()) {
            return List.of();
        }

        return taskMapper.toResponseDtoList(
                taskRepository.findByTitleContainingIgnoreCase(taskSearch)
        );
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        existingTask.setTitle(updatedTask.getTitle());
        return taskMapper.toResponseDto(taskRepository.save(existingTask));
    }

    public void deleteTask(Long id) {
        getTaskByID(id);
        taskRepository.deleteById(id);
    }
}
