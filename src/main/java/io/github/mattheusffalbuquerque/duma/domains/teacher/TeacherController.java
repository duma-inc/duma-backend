package io.github.mattheusffalbuquerque.duma.domains.teacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.ResponseEntity;
import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.TeacherResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.CreateTeacherRequest;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
@Tag(name = "Teacher", description = "Endpoints for managing teachers")
public class TeacherController {
    
    private final TeacherService teacherService;

    @GetMapping
    @Operation(summary = "Get all teachers", description = "Returns a list of all teachers in the system")
    public ResponseEntity<List<TeacherResponse>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get teacher by ID", description = "Returns a single teacher by their unique ID")
    public ResponseEntity<TeacherResponse> getTeacherById(@PathVariable UUID id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new teacher", description = "Creates a new teacher in the system")
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody CreateTeacherRequest request) {
        return ResponseEntity.ok(teacherService.createTeacher(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update teacher information", description = "Updates the information of an existing teacher identified by their unique ID")
    public ResponseEntity<TeacherResponse> updateTeacher(@PathVariable UUID id, @RequestBody CreateTeacherRequest request) {
        TeacherResponse response = teacherService.updateTeacher(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a teacher", description = "Deletes an existing teacher from the system identified by their unique ID")
    public ResponseEntity<Void> deleteTeacher(@PathVariable UUID id) {
        teacherService.deleteByUserId(id);
        return ResponseEntity.noContent().build();
    }

}
