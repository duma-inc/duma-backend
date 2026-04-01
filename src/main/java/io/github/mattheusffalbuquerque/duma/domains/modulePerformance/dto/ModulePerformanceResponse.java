package io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ModulePerformanceResponse", description = "Response containing module performance details")
public record ModulePerformanceResponse(

    @Schema(description = "The identifier of the student", example = "student-123")
    String studentId,
    @Schema(description = "The identifier of the module", example = "module-123")
    String moduleId,
    @Schema(description = "The total number of exercises", example = "10")
    Integer totalExercises,
    @Schema(description = "The number of completed exercises", example = "8")
    Integer exercisesCompleted,
    @Schema(description = "The average score", example = "85")
    Integer averageScore,
    @Schema(description = "The total time spent in minutes", example = "120")
    Integer timeSpentMinutes,
    @Schema(description = "The progress percentage", example = "80")
    Integer progressPercent,
    @Schema(description = "The creation date and time", example = "2024-01-01T10:00:00")
    LocalDateTime createdAt,
    @Schema(description = "The last update date and time", example = "2024-01-02T12:00:00")
    LocalDateTime updatedAt

) {}
