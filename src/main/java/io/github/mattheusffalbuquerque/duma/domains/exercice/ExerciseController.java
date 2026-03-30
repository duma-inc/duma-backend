package io.github.mattheusffalbuquerque.duma.domains.exercice;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.ExerciseResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.CreateExerciseRequest;
import org.springframework.web.bind.annotation.PutMapping;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.UpdateExerciseRequest;


@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
@Tag(name = "Exercise", description = "Endpoints for managing exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    @Operation(summary = "Get all exercises", description = "Returns a list of all exercises in the system")
    public ResponseEntity<List<ExerciseResponse>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.getAllExercises());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get exercise by ID", description = "Returns a single exercise by its unique ID")
    public ResponseEntity<ExerciseResponse> getExerciseById(@PathVariable String id) {
        return ResponseEntity.ok(exerciseService.getExercise(id));
    }

    @PostMapping
    @Operation(summary = "Create a new exercise", description = "Creates a new exercise in the system")
    public ResponseEntity<ExerciseResponse> createExercise(@RequestBody CreateExerciseRequest exerciseRequest) {
        ExerciseResponse createdExercise = exerciseService.createExercise(exerciseRequest);
        return ResponseEntity.ok(createdExercise);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing exercise", description = "Updates the information of an existing exercise identified by its unique ID")
    public ResponseEntity<ExerciseResponse> updateExercise(@PathVariable String id, @RequestBody UpdateExerciseRequest exerciseRequest) {
        ExerciseResponse updatedExercise = exerciseService.updateExercise(id, exerciseRequest);
        return ResponseEntity.ok(updatedExercise);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing exercise", description = "Deletes an existing exercise identified by its unique ID")
    public ResponseEntity<Void> deleteExercise(@PathVariable String id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
    


}
