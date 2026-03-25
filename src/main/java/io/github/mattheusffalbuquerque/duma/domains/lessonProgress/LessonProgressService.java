package io.github.mattheusffalbuquerque.duma.domains.lessonProgress;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.lesson.Lesson;
import io.github.mattheusffalbuquerque.duma.domains.lesson.LessonRepository;
import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.CreateLessonProgressRequest;
import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.LessonProgressResponse;
import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.UpdateLessonProgressRequest;
import io.github.mattheusffalbuquerque.duma.domains.student.Student;
import io.github.mattheusffalbuquerque.duma.domains.student.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonProgressService {

    private final LessonProgressRepository lessonProgressRepository;
    private final LessonProgressMapper lessonProgressMapper;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    public List<LessonProgressResponse> getAllLessonProgress() {
        return lessonProgressMapper.toResponseList(lessonProgressRepository.findAll());
    }

    public LessonProgressResponse getLessonProgressById(Long id) {
        LessonProgress lessonProgress = lessonProgressRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lesson progress not found with id: " + id));

        return lessonProgressMapper.toResponse(lessonProgress);
    }

    public List<LessonProgressResponse> getLessonProgressByStudentId(String studentId) {
        return lessonProgressMapper.toResponseList(lessonProgressRepository.findByStudentId(studentId));
    }

    public List<LessonProgressResponse> getLessonProgressByLessonId(String lessonId) {
        return lessonProgressMapper.toResponseList(lessonProgressRepository.findByLessonId(lessonId));
    }

    public LessonProgressResponse createLessonProgress(CreateLessonProgressRequest request) {
        LessonProgress lessonProgress = lessonProgressMapper.toEntity(request);
        lessonProgress.setStudent(getStudentById(request.studentId()));
        lessonProgress.setLesson(getLessonById(request.lessonId()));

        LessonProgress savedLessonProgress = lessonProgressRepository.save(lessonProgress);
        return lessonProgressMapper.toResponse(savedLessonProgress);
    }

    public LessonProgressResponse updateLessonProgress(Long id, UpdateLessonProgressRequest request) {
        LessonProgress existingLessonProgress = lessonProgressRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lesson progress not found with id: " + id));

        if (request.studentId() != null) {
            existingLessonProgress.setStudent(getStudentById(request.studentId()));
        }
        if (request.lessonId() != null) {
            existingLessonProgress.setLesson(getLessonById(request.lessonId()));
        }
        if (request.status() != null) {
            existingLessonProgress.setStatus(request.status());
        }
        if (request.progressPercent() != null) {
            existingLessonProgress.setProgressPercent(request.progressPercent());
        }
        if (request.watchedMinutes() != null) {
            existingLessonProgress.setWatchedMinutes(request.watchedMinutes());
        }
        if (request.startedAt() != null) {
            existingLessonProgress.setStartedAt(request.startedAt());
        }
        if (request.lastAccessAt() != null) {
            existingLessonProgress.setLastAccessAt(request.lastAccessAt());
        }
        if (request.completedAt() != null) {
            existingLessonProgress.setCompletedAt(request.completedAt());
        }

        LessonProgress updatedLessonProgress = lessonProgressRepository.save(existingLessonProgress);
        return lessonProgressMapper.toResponse(updatedLessonProgress);
    }

    public void deleteLessonProgress(Long id) {
        LessonProgress existingLessonProgress = lessonProgressRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lesson progress not found with id: " + id));

        lessonProgressRepository.delete(existingLessonProgress);
    }

    private Student getStudentById(String studentId) {
        return studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
    }

    private Lesson getLessonById(String lessonId) {
        return lessonRepository.findById(lessonId)
            .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + lessonId));
    }
}
