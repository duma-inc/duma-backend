package io.github.mattheusffalbuquerque.duma.domains.enrollment;

import java.util.List;

import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.CreateEnrollmentRequest;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.EnrollmentResponse;

public interface EnrollmentMapper {

        EnrollmentResponse toResponse(Enrollment enrollment);
    
        Enrollment toEntity(CreateEnrollmentRequest request);
    
        List<EnrollmentResponse> toResponseList(List<Enrollment> enrollments);
}
