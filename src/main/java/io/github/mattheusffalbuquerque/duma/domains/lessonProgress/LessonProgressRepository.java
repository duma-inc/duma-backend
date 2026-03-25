package io.github.mattheusffalbuquerque.duma.domains.lessonProgress;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.enums.LessonProgressStatus;

@Repository
public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {

    Optional<LessonProgress> findByStudentIdAndLessonId(String studentId, String lessonId);

    List<LessonProgress> findByStudentId(String studentId);

    List<LessonProgress> findByLessonId(String lessonId);

    List<LessonProgress> findByStatus(LessonProgressStatus status);

    Integer countByStudentId(String studentId);

    Integer countByLessonId(String lessonId);

    Integer countByStatus(LessonProgressStatus status);
}
