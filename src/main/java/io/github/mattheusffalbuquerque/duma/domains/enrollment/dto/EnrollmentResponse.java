package io.github.mattheusffalbuquerque.duma.domains.enrollment.dto;

public record EnrollmentResponse(

    Long id,
    Long userId,
    Long skillId,
    Long currentStageId,
    String status,
    Integer progressPercentage,
    String source,
    String pace

) {
}