package io.github.mattheusffalbuquerque.duma.domains.enrollment;

import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.CreateEnrollmentRequest;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.EnrollmentResponse;
import io.github.mattheusffalbuquerque.duma.domains.enrollment.dto.UpdateEnrollmentRequest;

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
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<EnrollmentResponse>> getAllEnrollments() {

        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponse> createEnrollment(@RequestBody CreateEnrollmentRequest enrollmentRequest) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(enrollmentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> updateEnrollment(@PathVariable Long id, @RequestBody UpdateEnrollmentRequest enrollmentRequest) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, enrollmentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }

}
