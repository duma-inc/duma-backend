package io.github.mattheusffalbuquerque.duma.domains.student;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.student.dto.StudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.github.mattheusffalbuquerque.duma.domains.student.dto.CreateStudentRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@Tag(name = "Student", description = "Endpoints for managing students")
public class StudentController {
    
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    
    @GetMapping
    @Operation(summary = "Get all students", description = "Returns a list of all students in the system")
    public List<StudentResponse> getAllStudents() {
        return studentMapper.toResponseList(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID", description = "Returns a single student by their unique ID")
    public String getStudent(@PathVariable String id) {
        return studentMapper.toResponse(studentService.getStudentById(id)).toString();        
    }
    
    @PostMapping
    @Operation(summary = "Create a new student", description = "Creates a new student in the system")
    public StudentResponse createStudent(CreateStudentRequest request) {
        return studentMapper.toResponse(studentService.createStudent(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a student", description = "Updates an existing student in the system")
    public StudentResponse updateStudent(@PathVariable String id, @RequestBody CreateStudentRequest request) {
        return studentMapper.toResponse(studentService.updateStudent(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a student", description = "Deletes an existing student from the system identified by their unique ID")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteByUserId(id);
    }

}
