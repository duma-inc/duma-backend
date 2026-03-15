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
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/modules")
public class ModuleController {
    
    private final ModuleService moduleService;

    @GetMapping
    public ResponseEntity<List<ModuleResponse>> getAllModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleResponse> getModuleById(@PathVariable String id) {
        return ResponseEntity.ok(moduleService.getModuleById(id));
    }

    @PostMapping
    public ResponseEntity<ModuleResponse> createModule(@RequestBody CreateModuleRequest moduleRequest) {
        return ResponseEntity.ok(moduleService.createModule(moduleRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleResponse> updateModule(@PathVariable String id, @RequestBody UpdateModuleRequest moduleRequest) {
        return ResponseEntity.ok(moduleService.updateModule(id, moduleRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable String id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }

}
