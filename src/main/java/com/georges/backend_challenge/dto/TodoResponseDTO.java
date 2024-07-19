package com.georges.backend_challenge.dto;

import java.time.LocalDateTime;

public record TodoResponseDTO(Long id, String name, String description, Boolean completed, String priority, LocalDateTime createdAt) {
}
