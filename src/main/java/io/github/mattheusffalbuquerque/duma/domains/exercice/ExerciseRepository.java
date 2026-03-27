package io.github.mattheusffalbuquerque.duma.domains.exercice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String> {

    Optional<Exercise> findById(String id);

    List<Exercise> findByLessonId(String lessonId);

    List<Exercise> findByType(ExerciseType type);

    List<ExerciseOptions> findOptionsByExerciseId(String exerciseId);

    List<Exercise> findByLessonAndType(String lessonId, ExerciseType type);

    Integer countByLessonId(String lessonId);

    void deleteByLessonId(String lessonId);
}
