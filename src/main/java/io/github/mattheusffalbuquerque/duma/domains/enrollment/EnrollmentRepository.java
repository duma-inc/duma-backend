package io.github.mattheusffalbuquerque.duma.domains.enrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentPace;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentSource;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.enums.EnrollmentStatus;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByUserId(Long userId);

    List<Enrollment> findBySkillId(Long skillId);

    List<Enrollment> findByCurrentStageId(Long stageId);

    List<Enrollment> findByPace(EnrollmentPace pace);

    List<Enrollment> findByStatus(EnrollmentStatus status);

    List<Enrollment> findBySource(EnrollmentSource source);

    Integer countBySkillId(Long skillId);

    Integer countByUserId(Long userId);

    Integer countByCurrentStageId(Long stageId);

    Integer countByPace(EnrollmentPace pace);

    Integer countByStatus(EnrollmentStatus status);

    Integer countBySource(EnrollmentSource source);
}
