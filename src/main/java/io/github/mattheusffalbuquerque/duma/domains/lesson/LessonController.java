package io.github.mattheusffalbuquerque.duma.domains.lesson;

import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.lesson.dto.CreateLessonRequest;
import io.github.mattheusffalbuquerque.duma.domains.lesson.dto.LessonResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<List<LessonResponse>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getLessonById(@PathVariable String id) {
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }

    @PostMapping
    public ResponseEntity<LessonResponse> createLesson(@RequestBody CreateLessonRequest request) {
        return ResponseEntity.ok(lessonService.createLesson(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> updateLesson(@PathVariable String id, @RequestBody CreateLessonRequest request) {
        return ResponseEntity.ok(lessonService.updateLesson(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable String id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }

}