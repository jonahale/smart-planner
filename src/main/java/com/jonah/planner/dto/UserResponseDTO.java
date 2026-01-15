package com.jonah.planner.dto;

import java.util.List;

public record UserResponseDTO(String name,
                              List<String> roles,
                              Long id
) {}
