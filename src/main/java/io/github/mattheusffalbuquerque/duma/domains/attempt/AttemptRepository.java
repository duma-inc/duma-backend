package io.github.mattheusffalbuquerque.duma.domains.attempt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    List<Attempt> findByStudentId(String studentId);

    List<Attempt> findByLessonId(String lessonId);

    List<Attempt> findByExerciseId(String exerciseId);

    List<Attempt> findByStudentIdAndLessonId(String studentId, String lessonId);

    List<Attempt> findByStudentIdAndExerciseId(String studentId, String exerciseId);

    Integer countByStudentId(String studentId);

    Integer countByLessonId(String lessonId);

    Integer countByExerciseId(String exerciseId);
}
