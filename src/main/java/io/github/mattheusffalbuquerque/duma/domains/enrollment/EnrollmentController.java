package io.github.mattheusffalbuquerque.duma.domains.enrollment;

import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.CreateEnrollmentRequest;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.EnrollmentResponse;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.UpdateEnrollmentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
@Tag(name = "Enrollment", description = "Endpoints for managing enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping
    @Operation(summary = "Get all enrollments", description = "Returns a list of all enrollments in the system")
    public ResponseEntity<List<EnrollmentResponse>> getAllEnrollments() {

        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get enrollment by ID", description = "Returns a single enrollment by its unique ID")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new enrollment", description = "Creates a new enrollment in the system")
    public ResponseEntity<EnrollmentResponse> createEnrollment(@RequestBody CreateEnrollmentRequest enrollmentRequest) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(enrollmentRequest));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update enrollment information", description = "Updates the information of an existing enrollment identified by its unique ID")
    public ResponseEntity<EnrollmentResponse> updateEnrollment(@PathVariable Long id, @RequestBody UpdateEnrollmentRequest enrollmentRequest) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, enrollmentRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an enrollment", description = "Deletes an existing enrollment from the system identified by its unique ID")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }

}
