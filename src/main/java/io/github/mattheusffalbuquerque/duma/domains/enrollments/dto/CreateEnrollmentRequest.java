package io.github.mattheusffalbuquerque.duma.domains.enrollments.dto;

import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentPace;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentStatus;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentSource;

public record CreateEnrollmentRequest(

    String userId,
    Long skillId,
    Long stageId,
    EnrollmentStatus status,
    EnrollmentSource source,
    EnrollmentPace pace

) {
}
