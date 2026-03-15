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
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/stages")
@RequiredArgsConstructor
public class StageController {

    private final StageService stageService;

    @GetMapping
    public ResponseEntity<List<StageResponse>> getAllStages() {
        return ResponseEntity.ok(stageService.getAllStages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageResponse> getStageById(@PathVariable Long id) {
        return ResponseEntity.ok(stageService.getStageById(id));
    }

    @PostMapping
    public ResponseEntity<StageResponse> createStage(@RequestBody CreateStageRequest request) {
        return ResponseEntity.ok(stageService.createStage(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StageResponse> updateStage(@PathVariable Long id, @RequestBody UpdateStageRequest request) {
        return ResponseEntity.ok(stageService.updateStage(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}