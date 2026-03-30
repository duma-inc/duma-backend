package io.github.mattheusffalbuquerque.duma.domains.lesson;

import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.lesson.dto.CreateLessonRequest;
import io.github.mattheusffalbuquerque.duma.domains.lesson.dto.LessonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Lesson", description = "Endpoints for managing lessons")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    @Operation(summary = "Get all lessons", description = "Returns a list of all lessons in the system")
    public ResponseEntity<List<LessonResponse>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get lesson by ID", description = "Returns a single lesson by its unique ID")
    public ResponseEntity<LessonResponse> getLessonById(@PathVariable String id) {
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new lesson", description = "Creates a new lesson in the system")
    public ResponseEntity<LessonResponse> createLesson(@RequestBody CreateLessonRequest request) {
        return ResponseEntity.ok(lessonService.createLesson(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing lesson", description = "Updates the information of an existing lesson identified by its unique ID")
    public ResponseEntity<LessonResponse> updateLesson(@PathVariable String id, @RequestBody CreateLessonRequest request) {
        return ResponseEntity.ok(lessonService.updateLesson(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing lesson", description = "Deletes an existing lesson identified by its unique ID")
    public ResponseEntity<Void> deleteLesson(@PathVariable String id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }

}