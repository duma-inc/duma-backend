package io.github.mattheusffalbuquerque.duma.domains.enrollment.dto;

import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentPace;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentSource;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentStatus;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateEnrollmentRequest", description = "Request to update an existing Enrollment")
public record UpdateEnrollmentRequest(

    @Schema(description = "The identifier of the user", example = "user-123")
    String userId,
    @Schema(description = "The identifier of the skill", example = "skill-123")
    Long skillId,
    @Schema(description = "The identifier of the stage", example = "stage-123")
    Long stageId,
    @Schema(description = "The status", example = "ACTIVE")
    EnrollmentStatus status,
    @Schema(description = "The source", example = "MANUAL")
    EnrollmentSource source,
    @Schema(description = "The pace", example = "SELF_PACED")
    EnrollmentPace pace

) {
}
