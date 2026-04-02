package io.github.mattheusffalbuquerque.duma.domains.student;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.List;
import java.util.UUID;
import io.github.mattheusffalbuquerque.duma.domains.student.dto.CreateStudentRequest;
import io.github.mattheusffalbuquerque.duma.domains.user.User;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Optional<Student> findByUserId(UUID userId) {
        return studentRepository.findByUserId(userId);
    }

    public Student createStudent(CreateStudentRequest request) {
        Student student = new Student();
        User user = new User();
        user.setId(parseUuid(request.userId()));
        student.setUser(user);
        student.setBio(request.bio());
        student.setProfilePictureUrl(request.profilePictureUrl());
        return studentRepository.save(student);
    }

    public Student updateStudent(UUID id, CreateStudentRequest request) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        if (request.userId() != null) {
            User user = new User();
            user.setId(parseUuid(request.userId()));
            existingStudent.setUser(user);
        }
        if (request.bio() != null) {
            existingStudent.setBio(request.bio());
        }
        if (request.profilePictureUrl() != null) {
            existingStudent.setProfilePictureUrl(request.profilePictureUrl());
        }
        return studentRepository.save(existingStudent);
    }

    public void deleteByUserId(UUID userId) {
        studentRepository.deleteByUserId(userId);
    }

    public Integer countActiveStudents() {
        return studentRepository.countByIsActiveTrue();
    }

    private UUID parseUuid(String id) {
        return UUID.fromString(id);
    }
}
