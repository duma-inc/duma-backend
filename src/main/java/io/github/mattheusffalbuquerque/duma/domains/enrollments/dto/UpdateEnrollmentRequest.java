package io.github.mattheusffalbuquerque.duma.domains.enrollments.dto;

import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentSource;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentStatus;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentPace;

public record UpdateEnrollmentRequest(

    String userId,
    Long skillId,
    Long stageId,
    EnrollmentStatus status,
    EnrollmentSource source,
    EnrollmentPace pace

) {
}
