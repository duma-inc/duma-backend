package io.github.mattheusffalbuquerque.duma.domains.stage;

import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.stage.dto.CreateStageRequest;
import io.github.mattheusffalbuquerque.duma.domains.stage.dto.StageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import io.github.mattheusffalbuquerque.duma.domains.stage.dto.UpdateStageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/stages")
@RequiredArgsConstructor
@Tag(name = "Stage", description = "Endpoints for managing stages")
public class StageController {

    private final StageService stageService;

    @GetMapping
    @Operation(summary = "Get all stages", description = "Returns a list of all stages in the system")
    public ResponseEntity<List<StageResponse>> getAllStages() {
        return ResponseEntity.ok(stageService.getAllStages());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get stage by ID", description = "Returns a single stage by its unique ID")
    public ResponseEntity<StageResponse> getStageById(@PathVariable Long id) {
        return ResponseEntity.ok(stageService.getStageById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new stage", description = "Creates a new stage in the system")
    public ResponseEntity<StageResponse> createStage(@RequestBody CreateStageRequest request) {
        return ResponseEntity.ok(stageService.createStage(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update stage information", description = "Updates the information of an existing stage identified by its unique ID")
    public ResponseEntity<StageResponse> updateStage(@PathVariable Long id, @RequestBody UpdateStageRequest request) {
        return ResponseEntity.ok(stageService.updateStage(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a stage", description = "Deletes an existing stage from the system identified by its unique ID")
    public ResponseEntity<Void> deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
        return ResponseEntity.noContent().build();
    }
}