package io.github.mattheusffalbuquerque.duma.domains.modulePerformance;

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

import io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto.CreateModulePerformanceRequest;
import io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto.ModulePerformanceResponse;
import io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto.UpdateModulePerformanceRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/module-performance")
public class ModulePerformanceController {

    private final ModulePerformanceService modulePerformanceService;

    @GetMapping
    public ResponseEntity<List<ModulePerformanceResponse>> getAllModulePerformance() {
        return ResponseEntity.ok(modulePerformanceService.getAllModulePerformance());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModulePerformanceResponse> getModulePerformanceById(@PathVariable Long id) {
        return ResponseEntity.ok(modulePerformanceService.getModulePerformanceById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ModulePerformanceResponse>> getModulePerformanceByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(modulePerformanceService.getModulePerformanceByStudentId(studentId));
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<ModulePerformanceResponse>> getModulePerformanceByModuleId(@PathVariable String moduleId) {
        return ResponseEntity.ok(modulePerformanceService.getModulePerformanceByModuleId(moduleId));
    }

    @PostMapping
    public ResponseEntity<ModulePerformanceResponse> createModulePerformance(@RequestBody CreateModulePerformanceRequest request) {
        return ResponseEntity.ok(modulePerformanceService.createModulePerformance(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModulePerformanceResponse> updateModulePerformance(
        @PathVariable Long id,
        @RequestBody UpdateModulePerformanceRequest request
    ) {
        return ResponseEntity.ok(modulePerformanceService.updateModulePerformance(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModulePerformance(@PathVariable Long id) {
        modulePerformanceService.deleteModulePerformance(id);
        return ResponseEntity.noContent().build();
    }
}
