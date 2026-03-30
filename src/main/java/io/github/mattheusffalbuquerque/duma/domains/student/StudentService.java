package io.github.mattheusffalbuquerque.duma.domains.student;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.student.dto.CreateStudentRequest;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Optional<Student> findByUserId(String userId) {
        return studentRepository.findByUserId(userId);
    }

    public Student createStudent(CreateStudentRequest request) {
        Student student = studentMapper.toEntity(request);
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, CreateStudentRequest request) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentMapper.toEntity(request, existingStudent);
        return studentRepository.save(existingStudent);
    }

    public void deleteByUserId(String userId) {
        studentRepository.deleteByUserId(userId);
    }

    public Integer countActiveStudents() {
        return studentRepository.countByIsActiveTrue();
    }
}

