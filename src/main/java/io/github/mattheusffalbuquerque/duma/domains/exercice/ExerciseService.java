package io.github.mattheusffalbuquerque.duma.domains.exercice;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.CreateExerciseRequest;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.ExerciseResponse;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.UpdateExerciseRequest;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.ExerciseOptionsResponse;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public List<ExerciseResponse> getAllExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exerciseMapper.toResponseList(exercises);
    }

    public List<ExerciseResponse> getExercisesByLesson(String lessonId) {
        List<Exercise> exercises = exerciseRepository.findByLessonId(lessonId);
        return exerciseMapper.toResponseList(exercises);
    }

    public ExerciseResponse getExercise(String exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
            .orElseThrow(() -> new RuntimeException("Exercise not found"));
        return exerciseMapper.toResponse(exercise);
    }

    public ExerciseResponse createExercise(CreateExerciseRequest request) {
        Exercise exercise = exerciseMapper.toEntity(request);
        exercise = exerciseRepository.save(exercise);
        return exerciseMapper.toResponse(exercise);
    }

    public ExerciseResponse updateExercise(String exerciseId, UpdateExerciseRequest request) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
            .orElseThrow(() -> new RuntimeException("Exercise not found"));
        exercise = exerciseMapper.toEntity(request);
        exerciseRepository.save(exercise);
        return exerciseMapper.toResponse(exercise);
    }

    public List<ExerciseOptionsResponse> getOptionsByExercise(String exerciseId) {
        List<ExerciseOptions> options = exerciseRepository.findOptionsByExerciseId(exerciseId);
        return exerciseMapper.toResponse(options);
    }

    public List<ExerciseOptionsResponse> updateOptions(String exerciseId, List<ExerciseOptionsResponse> options) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
            .orElseThrow(() -> new RuntimeException("Exercise not found"));
        exercise.setOptions(exerciseMapper.toEntity(options));
        exerciseRepository.save(exercise);
        return exerciseMapper.toResponse(exercise.getOptions());
    }

    public void deleteExercise(String exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
            .orElseThrow(() -> new RuntimeException("Exercise not found"));
        exerciseRepository.delete(exercise);
    }
}
