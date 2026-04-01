package io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateModulePerformanceRequest", description = "Request to create a new Module Performance")
public record CreateModulePerformanceRequest(

    @Schema(description = "The identifier of the student", example = "student-123")
    String studentId,
    @Schema(description = "The identifier of the module", example = "module-123")
    String moduleId,
    @Schema(description = "The total number of exercises", example = "100")
    Integer totalExercises,
    @Schema(description = "The number of completed exercises", example = "80")
    Integer exercisesCompleted,
    @Schema(description = "The average score", example = "85")
    Integer averageScore,
    @Schema(description = "The total time spent in minutes", example = "120")
    Integer timeSpentMinutes,
    @Schema(description = "The progress percentage", example = "80")
    Integer progressPercent

) {}
