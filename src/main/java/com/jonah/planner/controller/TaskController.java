package com.jonah.planner.controller;

import com.jonah.planner.dto.TaskRequestDTO;
import com.jonah.planner.dto.TaskResponseDTO;
import com.jonah.planner.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/search")
    public List<TaskResponseDTO> searchTasks(@RequestParam(required = false) String title) {
        return taskService.searchTaskByTitle(title);
    }

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTask(@PathVariable Long id) {
        return taskService.getTaskByID(id);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(
            @PathVariable Long id,
            @RequestBody TaskRequestDTO task
    ) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
