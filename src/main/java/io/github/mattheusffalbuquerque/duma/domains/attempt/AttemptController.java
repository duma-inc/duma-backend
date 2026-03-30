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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attempts")
@Tag(name = "Attempt", description = "Endpoints for managing attempts")
public class AttemptController {

    private final AttemptService attemptService;

    @GetMapping
    @Operation(summary = "Get all attempts", description = "Returns a list of all attempts in the system")
    public ResponseEntity<List<AttemptResponse>> getAllAttempts() {
        return ResponseEntity.ok(attemptService.getAllAttempts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get attempt by ID", description = "Returns a single attempt by its unique ID")
    public ResponseEntity<AttemptResponse> getAttemptById(@PathVariable Long id) {
        return ResponseEntity.ok(attemptService.getAttemptById(id));
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get attempts by student ID", description = "Returns a list of attempts associated with a specific student")
    public ResponseEntity<List<AttemptResponse>> getAttemptsByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(attemptService.getAttemptsByStudentId(studentId));
    }

    @GetMapping("/lesson/{lessonId}")
    @Operation(summary = "Get attempts by lesson ID", description = "Returns a list of attempts associated with a specific lesson")
    public ResponseEntity<List<AttemptResponse>> getAttemptsByLessonId(@PathVariable String lessonId) {
        return ResponseEntity.ok(attemptService.getAttemptsByLessonId(lessonId));
    }

    @GetMapping("/exercise/{exerciseId}")
    @Operation(summary = "Get attempts by exercise ID", description = "Returns a list of attempts associated with a specific exercise")
    public ResponseEntity<List<AttemptResponse>> getAttemptsByExerciseId(@PathVariable String exerciseId) {
        return ResponseEntity.ok(attemptService.getAttemptsByExerciseId(exerciseId));
    }

    @GetMapping("/by-student-and-lesson")
    @Operation(summary = "Get attempts by student ID and lesson ID", description = "Returns a list of attempts associated with a specific student and lesson")
    public ResponseEntity<List<AttemptResponse>> getAttemptsByStudentIdAndLessonId(
        @RequestParam String studentId,
        @RequestParam String lessonId
    ) {
        return ResponseEntity.ok(attemptService.getAttemptsByStudentIdAndLessonId(studentId, lessonId));
    }

    @PostMapping
    @Operation(summary = "Create a new attempt", description = "Creates a new attempt in the system")
    public ResponseEntity<AttemptResponse> createAttempt(@RequestBody CreateAttemptRequest request) {
        return ResponseEntity.ok(attemptService.createAttempt(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing attempt", description = "Updates the information of an existing attempt identified by its unique ID")
    public ResponseEntity<AttemptResponse> updateAttempt(
        @PathVariable Long id,
        @RequestBody UpdateAttemptRequest request
    ) {
        return ResponseEntity.ok(attemptService.updateAttempt(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing attempt", description = "Deletes an existing attempt identified by its unique ID")
    public ResponseEntity<Void> deleteAttempt(@PathVariable Long id) {
        attemptService.deleteAttempt(id);
        return ResponseEntity.noContent().build();
    }
}
