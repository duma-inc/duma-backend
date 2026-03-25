package io.github.mattheusffalbuquerque.duma.domains.enrollment.dto;

import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentPace;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentSource;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentStatus;

public record UpdateEnrollmentRequest(

    String userId,
    Long skillId,
    Long stageId,
    EnrollmentStatus status,
    EnrollmentSource source,
    EnrollmentPace pace

) {
}
