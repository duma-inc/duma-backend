package io.github.mattheusffalbuquerque.duma.domains.teacher;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.TeacherResponse;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public List<TeacherResponse> getAllTeachers() {
        return teacherMapper.toResponseList(teacherRepository.findAll());
    }

    public TeacherResponse getTeacherById(String id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return teacherMapper.toResponse(teacher);
    }

     public TeacherResponse getTeacherByUserId(String userId) {
        Teacher teacher = teacherRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Teacher not found with userId: " + userId));
        return teacherMapper.toResponse(teacher);
    }

    public TeacherResponse createTeacher(Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toResponse(savedTeacher);
    }

    public TeacherResponse updateTeacher(Teacher teacher) {
        Teacher updatedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toResponse(updatedTeacher);
    }

     public void deleteByUserId(String userId) {
        teacherRepository.deleteByUserId(userId);
    }

     public Integer countActiveTeachers() {
        return teacherRepository.countByIsActiveTrue();
    }

}
