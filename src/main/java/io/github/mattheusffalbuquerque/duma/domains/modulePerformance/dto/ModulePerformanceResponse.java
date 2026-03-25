package io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto;

import java.time.LocalDateTime;

public record ModulePerformanceResponse(

    Long id,
    String studentId,
    String moduleId,
    Integer totalExercises,
    Integer exercisesCompleted,
    Integer averageScore,
    Integer timeSpentMinutes,
    Integer progressPercent,
    LocalDateTime createdAt,
    LocalDateTime updatedAt

) {}
