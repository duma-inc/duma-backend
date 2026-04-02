package io.github.mattheusffalbuquerque.duma.domains.attempt;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    List<Attempt> findByStudentId(UUID studentId);

    List<Attempt> findByLessonId(UUID lessonId);

    List<Attempt> findByExerciseId(String exerciseId);

    List<Attempt> findByStudentIdAndLessonId(UUID studentId, UUID lessonId);

    List<Attempt> findByStudentIdAndExerciseId(String studentId, String exerciseId);

    Integer countByStudentId(UUID studentId);

    Integer countByLessonId(UUID lessonId);

    Integer countByExerciseId(String exerciseId);
}
