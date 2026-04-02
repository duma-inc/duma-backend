package io.github.mattheusffalbuquerque.duma.domains.lessonProgress;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.enums.LessonProgressStatus;

@Repository
public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {

    Optional<LessonProgress> findByStudentIdAndLessonId(UUID studentId, UUID lessonId);

    List<LessonProgress> findByStudentId(UUID studentId);

    List<LessonProgress> findByLessonId(UUID lessonId);

    List<LessonProgress> findByStatus(LessonProgressStatus status);

    Integer countByStudentId(UUID studentId);

    Integer countByLessonId(UUID lessonId);

    Integer countByStatus(LessonProgressStatus status);
    
    @Query("""
        SELECT COUNT(lp)
        FROM LessonProgress lp
        WHERE lp.student.id = :studentId
        AND lp.lesson.module.id = :moduleId
        AND lp.status = LessonProgressStatus.COMPLETED
    """)
    Integer countCompletedLessonsByStudentAndModule(@Param("studentId") UUID studentId, @Param("moduleId") UUID moduleId);
}
