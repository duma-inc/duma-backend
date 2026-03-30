package io.github.mattheusffalbuquerque.duma.domains.lessonProgress;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.CreateLessonProgressRequest;
import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.LessonProgressResponse;
import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.UpdateLessonProgressRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.ModuleProgressResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson-progress")
@Tag(name = "Lesson Progress", description = "Endpoints for managing lesson progress records")
public class LessonProgressController {

    private final LessonProgressService lessonProgressService;

    @GetMapping
    @Operation(summary = "Get all lesson progress records", description = "Returns a list of all lesson progress records in the system")
    public ResponseEntity<List<LessonProgressResponse>> getAllLessonProgress() {
        return ResponseEntity.ok(lessonProgressService.getAllLessonProgress());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get lesson progress by ID", description = "Returns a single lesson progress record by its unique ID")
    public ResponseEntity<LessonProgressResponse> getLessonProgressById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonProgressService.getLessonProgressById(id));
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get lesson progress by student ID", description = "Returns a list of lesson progress records associated with a specific student")
    public ResponseEntity<List<LessonProgressResponse>> getLessonProgressByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(lessonProgressService.getLessonProgressByStudentId(studentId));
    }

    @GetMapping("/lesson/{lessonId}")
    @Operation(summary = "Get lesson progress by lesson ID", description = "Returns a list of lesson progress records associated with a specific lesson")
    public ResponseEntity<List<LessonProgressResponse>> getLessonProgressByLessonId(@PathVariable String lessonId) {
        return ResponseEntity.ok(lessonProgressService.getLessonProgressByLessonId(lessonId));
    }

    @GetMapping("/moduleprogress")
    @Operation(summary = "Get module progress for a student", description = "Returns the progress of a student in a specific module, including the number of completed lessons and total lessons")
    public ResponseEntity<ModuleProgressResponse> getProgress(@RequestParam String studentId, @RequestParam String moduleId) {
        ModuleProgressResponse progress = lessonProgressService.countCompletedLessonsByStudentAndModule(studentId, moduleId);
        return ResponseEntity.ok(progress);
    }        

    @PostMapping
    @Operation(summary = "Create a new lesson progress record", description = "Creates a new lesson progress record in the system")
    public ResponseEntity<LessonProgressResponse> createLessonProgress(@RequestBody CreateLessonProgressRequest request) {
        return ResponseEntity.ok(lessonProgressService.createLessonProgress(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update lesson progress information", description = "Updates the information of an existing lesson progress record identified by its unique ID")
    public ResponseEntity<LessonProgressResponse> updateLessonProgress(
        @PathVariable Long id,
        @RequestBody UpdateLessonProgressRequest request
    ) {
        return ResponseEntity.ok(lessonProgressService.updateLessonProgress(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a lesson progress record", description = "Deletes an existing lesson progress record from the system identified by its unique ID")
    public ResponseEntity<Void> deleteLessonProgress(@PathVariable Long id) {
        lessonProgressService.deleteLessonProgress(id);
        return ResponseEntity.noContent().build();
    }
}
