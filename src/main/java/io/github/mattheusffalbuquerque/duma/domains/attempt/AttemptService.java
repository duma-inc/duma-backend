package io.github.mattheusffalbuquerque.duma.domains.attempt;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.attempt.dto.AttemptResponse;
import io.github.mattheusffalbuquerque.duma.domains.attempt.dto.CreateAttemptRequest;
import io.github.mattheusffalbuquerque.duma.domains.attempt.dto.UpdateAttemptRequest;
import io.github.mattheusffalbuquerque.duma.domains.exercice.ExerciseRepository;
import io.github.mattheusffalbuquerque.duma.domains.lesson.Lesson;
import io.github.mattheusffalbuquerque.duma.domains.lesson.LessonRepository;
import io.github.mattheusffalbuquerque.duma.domains.student.Student;
import io.github.mattheusffalbuquerque.duma.domains.student.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttemptService {

    private final AttemptRepository attemptRepository;
    private final AttemptMapper attemptMapper;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final ExerciseRepository exerciseRepository;

    public List<AttemptResponse> getAllAttempts() {
        return attemptMapper.toResponseList(attemptRepository.findAll());
    }

    public AttemptResponse getAttemptById(Long id) {
        Attempt attempt = attemptRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Attempt not found with id: " + id));

        return attemptMapper.toResponse(attempt);
    }

    public List<AttemptResponse> getAttemptsByStudentId(String studentId) {
        return attemptMapper.toResponseList(attemptRepository.findByStudentId(parseUuid(studentId)));
    }

    public List<AttemptResponse> getAttemptsByLessonId(String lessonId) {
        return attemptMapper.toResponseList(attemptRepository.findByLessonId(parseUuid(lessonId)));
    }

    public List<AttemptResponse> getAttemptsByExerciseId(String exerciseId) {
        return attemptMapper.toResponseList(attemptRepository.findByExerciseId(exerciseId));
    }

    public List<AttemptResponse> getAttemptsByStudentIdAndLessonId(String studentId, String lessonId) {
        return attemptMapper.toResponseList(attemptRepository.findByStudentIdAndLessonId(parseUuid(studentId), parseUuid(lessonId)));
    }

    public AttemptResponse createAttempt(CreateAttemptRequest request) {
        Attempt attempt = attemptMapper.toEntity(request);
        attempt.setStudent(getStudentById(request.studentId()));
        attempt.setLesson(getLessonById(request.lessonId()));
        validateExerciseExists(request.exerciseId());

        Attempt savedAttempt = attemptRepository.save(attempt);
        return attemptMapper.toResponse(savedAttempt);
    }

    public AttemptResponse updateAttempt(Long id, UpdateAttemptRequest request) {
        Attempt existingAttempt = attemptRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Attempt not found with id: " + id));

        if (request.studentId() != null) {
            existingAttempt.setStudent(getStudentById(request.studentId()));
        }
        if (request.lessonId() != null) {
            existingAttempt.setLesson(getLessonById(request.lessonId()));
        }
        if (request.exerciseId() != null) {
            validateExerciseExists(request.exerciseId());
            existingAttempt.setExerciseId(request.exerciseId());
        }
        if (request.answerGiven() != null) {
            existingAttempt.setAnswerGiven(request.answerGiven());
        }
        if (request.isCorrect() != null) {
            existingAttempt.setIsCorrect(request.isCorrect());
        }
        if (request.score() != null) {
            existingAttempt.setScore(request.score());
        }
        if (request.timeSpentSeconds() != null) {
            existingAttempt.setTimeSpentSeconds(request.timeSpentSeconds());
        }

        Attempt updatedAttempt = attemptRepository.save(existingAttempt);
        return attemptMapper.toResponse(updatedAttempt);
    }

    public void deleteAttempt(Long id) {
        Attempt existingAttempt = attemptRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Attempt not found with id: " + id));

        attemptRepository.delete(existingAttempt);
    }

    private Student getStudentById(String studentId) {
        return studentRepository.findById(parseUuid(studentId))
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
    }

    private Lesson getLessonById(String lessonId) {
        return lessonRepository.findById(parseUuid(lessonId))
            .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + lessonId));
    }

    private void validateExerciseExists(String exerciseId) {
        if (!exerciseRepository.existsById(exerciseId)) {
            throw new RuntimeException("Exercise not found with id: " + exerciseId);
        }
    }

    private UUID parseUuid(String id) {
        return UUID.fromString(id);
    }
}
