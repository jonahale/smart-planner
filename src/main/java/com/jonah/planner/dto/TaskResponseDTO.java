package com.jonah.planner.dto;

import java.time.LocalDate;
public record TaskResponseDTO(
        Long id,
        String title,
        boolean completed,
        LocalDate dueDate
) {}
