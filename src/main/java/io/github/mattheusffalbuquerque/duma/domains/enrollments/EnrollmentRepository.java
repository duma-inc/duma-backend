package io.github.mattheusffalbuquerque.duma.domains.enrollments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentPace;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentSource;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentStatus;

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
