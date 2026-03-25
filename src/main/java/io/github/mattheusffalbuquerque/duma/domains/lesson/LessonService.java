package io.github.mattheusffalbuquerque.duma.domains.lesson;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.lesson.dto.CreateLessonRequest;
import io.github.mattheusffalbuquerque.duma.domains.lesson.dto.LessonResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    public List<LessonResponse> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessonMapper.toResponseList(lessons);
    }

    public LessonResponse getLessonById(String id) {
        Lesson lesson = lessonRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));
        return lessonMapper.toResponse(lesson);
    }

    public LessonResponse createLesson(CreateLessonRequest request) {
        Lesson lesson = lessonMapper.toEntity(request);
        Lesson savedLesson = lessonRepository.save(lesson);
        return lessonMapper.toResponse(savedLesson);
    }

    public LessonResponse updateLesson(String id, CreateLessonRequest request) {
        Lesson existingLesson = lessonRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));

        if (request.title() != null) {
            existingLesson.setTitle(request.title());
        }
        if (request.content() != null) {
            existingLesson.setContent(request.content());
        }
        if (request.orderIndex() != null) {
            existingLesson.setOrderIndex(request.orderIndex());
        }
        if (request.isActive() != null) {
            existingLesson.setIsActive(request.isActive());
        }

        Lesson updatedLesson = lessonRepository.save(existingLesson);
        return lessonMapper.toResponse(updatedLesson);
    }

    public List<LessonResponse> getLessonsByModuleId(String moduleId) {
        List<Lesson> lessons = lessonRepository.findByModuleId(moduleId);
        return lessonMapper.toResponseList(lessons);
    }

    public void deleteLesson(String id) {
        Lesson existingLesson = lessonRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));
        lessonRepository.delete(existingLesson);
    }


}
