package io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto;

public record CreateModulePerformanceRequest(

    String studentId,
    String moduleId,
    Integer totalExercises,
    Integer exercisesCompleted,
    Integer averageScore,
    Integer timeSpentMinutes,
    Integer progressPercent

) {}
