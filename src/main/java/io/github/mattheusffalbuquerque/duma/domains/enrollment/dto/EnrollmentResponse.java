package io.github.mattheusffalbuquerque.duma.domains.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "EnrollmentResponse", description = "Response containing enrollment details")
public record EnrollmentResponse(

    @Schema(description = "The identifier of the record", example = "11")
    Long id,
    @Schema(description = "The identifier of the user", example = "user-123")
    Long userId,
    @Schema(description = "The identifier of the skill", example = "skill-123")
    Long skillId,
    @Schema(description = "The identifier of the current stage", example = "stage-123")
    Long currentStageId,
    @Schema(description = "The status", example = "ACTIVE")
    String status,
    @Schema(description = "The progress percentage", example = "80")
    Integer progressPercentage,
    @Schema(description = "The source", example = "MANUAL")
    String source,
    @Schema(description = "The pace", example = "SELF_PACED")
    String pace

) {
}
