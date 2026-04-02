package io.github.mattheusffalbuquerque.duma.domains.module;

import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.module.dto.ModuleResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.github.mattheusffalbuquerque.duma.domains.module.dto.CreateModuleRequest;
import org.springframework.web.bind.annotation.PutMapping;
import io.github.mattheusffalbuquerque.duma.domains.module.dto.UpdateModuleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/modules")
@Tag(name = "Module", description = "Endpoints for managing modules")
public class ModuleController {
    
    private final ModuleService moduleService;

    @GetMapping
    @Operation(summary = "Get all modules", description = "Returns a list of all modules in the system")
    public ResponseEntity<List<ModuleResponse>> getAllModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get module by ID", description = "Returns a single module by its unique ID")
    public ResponseEntity<ModuleResponse> getModuleById(@PathVariable UUID id) {
        return ResponseEntity.ok(moduleService.getModuleById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new module", description = "Creates a new module in the system")
    public ResponseEntity<ModuleResponse> createModule(@RequestBody CreateModuleRequest moduleRequest) {
        return ResponseEntity.ok(moduleService.createModule(moduleRequest));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update module information", description = "Updates the information of an existing module identified by its unique ID")
    public ResponseEntity<ModuleResponse> updateModule(@PathVariable UUID id, @RequestBody UpdateModuleRequest moduleRequest) {
        return ResponseEntity.ok(moduleService.updateModule(id, moduleRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a module", description = "Deletes an existing module from the system identified by its unique ID")
    public ResponseEntity<Void> deleteModule(@PathVariable UUID id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }

}
