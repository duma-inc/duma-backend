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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/module-performance")
@Tag(name = "Module Performance", description = "Endpoints for managing module performance records")
public class ModulePerformanceController {

    private final ModulePerformanceService modulePerformanceService;

    @GetMapping
    @Operation(summary = "Get all module performance records", description = "Returns a list of all module performance records in the system")
    public ResponseEntity<List<ModulePerformanceResponse>> getAllModulePerformance() {
        return ResponseEntity.ok(modulePerformanceService.getAllModulePerformance());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get module performance by ID", description = "Returns a single module performance record by its unique ID")
    public ResponseEntity<ModulePerformanceResponse> getModulePerformanceById(@PathVariable Long id) {
        return ResponseEntity.ok(modulePerformanceService.getModulePerformanceById(id));
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get module performance by student ID", description = "Returns a list of module performance records for a specific student")
    public ResponseEntity<List<ModulePerformanceResponse>> getModulePerformanceByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(modulePerformanceService.getModulePerformanceByStudentId(studentId));
    }

    @GetMapping("/module/{moduleId}")
    @Operation(summary = "Get module performance by module ID", description = "Returns a list of module performance records for a specific module")
    public ResponseEntity<List<ModulePerformanceResponse>> getModulePerformanceByModuleId(@PathVariable String moduleId) {
        return ResponseEntity.ok(modulePerformanceService.getModulePerformanceByModuleId(moduleId));
    }

    @PostMapping
    @Operation(summary = "Create a new module performance record", description = "Creates a new module performance record in the system")
    public ResponseEntity<ModulePerformanceResponse> createModulePerformance(@RequestBody CreateModulePerformanceRequest request) {
        return ResponseEntity.ok(modulePerformanceService.createModulePerformance(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update module performance information", description = "Updates the information of an existing module performance record identified by its unique ID")
    public ResponseEntity<ModulePerformanceResponse> updateModulePerformance(
        @PathVariable Long id,
        @RequestBody UpdateModulePerformanceRequest request
    ) {
        return ResponseEntity.ok(modulePerformanceService.updateModulePerformance(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a module performance record", description = "Deletes an existing module performance record from the system identified by its unique ID")
    public ResponseEntity<Void> deleteModulePerformance(@PathVariable Long id) {
        modulePerformanceService.deleteModulePerformance(id);
        return ResponseEntity.noContent().build();
    }
}
