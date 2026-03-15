package io.github.mattheusffalbuquerque.duma.domains.enrollments;

import io.github.mattheusffalbuquerque.duma.domains.enrollments.dto.CreateEnrollmentRequest;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.dto.EnrollmentResponse;
import java.util.List;

public interface EnrollmentMapper {

        EnrollmentResponse toResponse(Enrollment enrollment);
    
        Enrollment toEntity(CreateEnrollmentRequest request);
    
        List<EnrollmentResponse> toResponseList(List<Enrollment> enrollments);
}
