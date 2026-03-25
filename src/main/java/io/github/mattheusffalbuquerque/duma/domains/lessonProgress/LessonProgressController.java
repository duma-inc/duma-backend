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
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.ModuleProgressResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson-progress")
public class LessonProgressController {

    private final LessonProgressService lessonProgressService;

    @GetMapping
    public ResponseEntity<List<LessonProgressResponse>> getAllLessonProgress() {
        return ResponseEntity.ok(lessonProgressService.getAllLessonProgress());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonProgressResponse> getLessonProgressById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonProgressService.getLessonProgressById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<LessonProgressResponse>> getLessonProgressByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(lessonProgressService.getLessonProgressByStudentId(studentId));
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<LessonProgressResponse>> getLessonProgressByLessonId(@PathVariable String lessonId) {
        return ResponseEntity.ok(lessonProgressService.getLessonProgressByLessonId(lessonId));
    }

    @GetMapping("/progress")
    public ResponseEntity<ModuleProgressResponse> getProgress(@RequestParam String studentId, @RequestParam String moduleId) {
        ModuleProgressResponse progress = lessonProgressService.countCompletedLessonsByStudentAndModule(studentId, moduleId);
        return ResponseEntity.ok(progress);
    }
    

    @PostMapping
    public ResponseEntity<LessonProgressResponse> createLessonProgress(@RequestBody CreateLessonProgressRequest request) {
        return ResponseEntity.ok(lessonProgressService.createLessonProgress(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonProgressResponse> updateLessonProgress(
        @PathVariable Long id,
        @RequestBody UpdateLessonProgressRequest request
    ) {
        return ResponseEntity.ok(lessonProgressService.updateLessonProgress(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLessonProgress(@PathVariable Long id) {
        lessonProgressService.deleteLessonProgress(id);
        return ResponseEntity.noContent().build();
    }
}
