package io.github.mattheusffalbuquerque.duma.domains.enrollment;

import java.util.List;

import org.springframework.stereotype.Component;

import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.CreateEnrollmentRequest;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.EnrollmentResponse;

@Component
public class EnrollmentMapperImpl implements EnrollmentMapper {

    @Override
    public EnrollmentResponse toResponse(Enrollment enrollment) {
        if (enrollment == null) {
            return null;
        }

        return new EnrollmentResponse(
            enrollment.getId(),
            enrollment.getUser() != null && enrollment.getUser().getId() != null
                ? enrollment.getUser().getId().toString()
                : null,
            enrollment.getSkill() != null ? enrollment.getSkill().getId() : null,
            enrollment.getCurrentStage() != null ? enrollment.getCurrentStage().getId() : null,
            enrollment.getStatus() != null ? enrollment.getStatus().name() : null,
            enrollment.getProgressPercentage(),
            enrollment.getSource() != null ? enrollment.getSource().name() : null,
            enrollment.getPace() != null ? enrollment.getPace().name() : null
        );
    }

    @Override
    public Enrollment toEntity(CreateEnrollmentRequest request) {
        throw new UnsupportedOperationException("Use EnrollmentService to assemble Enrollment entities");
    }

    @Override
    public List<EnrollmentResponse> toResponseList(List<Enrollment> enrollments) {
        return enrollments.stream()
            .map(this::toResponse)
            .toList();
    }
}
