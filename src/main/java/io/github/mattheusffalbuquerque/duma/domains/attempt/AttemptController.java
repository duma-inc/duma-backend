package io.github.mattheusffalbuquerque.duma.domains.attempt;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.attempt.dto.AttemptResponse;
import io.github.mattheusffalbuquerque.duma.domains.attempt.dto.CreateAttemptRequest;
import io.github.mattheusffalbuquerque.duma.domains.attempt.dto.UpdateAttemptRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attempts")
public class AttemptController {

    private final AttemptService attemptService;

    @GetMapping
    public ResponseEntity<List<AttemptResponse>> getAllAttempts() {
        return ResponseEntity.ok(attemptService.getAllAttempts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttemptResponse> getAttemptById(@PathVariable Long id) {
        return ResponseEntity.ok(attemptService.getAttemptById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AttemptResponse>> getAttemptsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(attemptService.getAttemptsByStudentId(studentId));
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<AttemptResponse>> getAttemptsByLessonId(@PathVariable String lessonId) {
        return ResponseEntity.ok(attemptService.getAttemptsByLessonId(lessonId));
    }

    @GetMapping("/exercise/{exerciseId}")
    public ResponseEntity<List<AttemptResponse>> getAttemptsByExerciseId(@PathVariable String exerciseId) {
        return ResponseEntity.ok(attemptService.getAttemptsByExerciseId(exerciseId));
    }

    @GetMapping("/by-student-and-lesson")
    public ResponseEntity<List<AttemptResponse>> getAttemptsByStudentIdAndLessonId(
        @RequestParam String studentId,
        @RequestParam String lessonId
    ) {
        return ResponseEntity.ok(attemptService.getAttemptsByStudentIdAndLessonId(studentId, lessonId));
    }

    @PostMapping
    public ResponseEntity<AttemptResponse> createAttempt(@RequestBody CreateAttemptRequest request) {
        return ResponseEntity.ok(attemptService.createAttempt(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttemptResponse> updateAttempt(
        @PathVariable Long id,
        @RequestBody UpdateAttemptRequest request
    ) {
        return ResponseEntity.ok(attemptService.updateAttempt(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttempt(@PathVariable Long id) {
        attemptService.deleteAttempt(id);
        return ResponseEntity.noContent().build();
    }
}
