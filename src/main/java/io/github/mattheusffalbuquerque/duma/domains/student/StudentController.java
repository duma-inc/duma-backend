package io.github.mattheusffalbuquerque.duma.domains.student;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.student.dto.StudentResponse;
import io.github.mattheusffalbuquerque.duma.domains.student.dto.CreateStudentRequest;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    
    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentMapper.toResponseList(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable String id) {
        return studentMapper.toResponse(studentService.getStudentById(id)).toString();        
    }
    
    @PostMapping
    public StudentResponse createStudent(CreateStudentRequest request) {
        return studentMapper.toResponse(studentService.createStudent(request));
    }

}
