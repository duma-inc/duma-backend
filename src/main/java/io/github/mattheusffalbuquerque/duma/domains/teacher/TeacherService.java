package io.github.mattheusffalbuquerque.duma.domains.teacher;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.TeacherResponse;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.UUID;
import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.CreateTeacherRequest;
import io.github.mattheusffalbuquerque.duma.domains.user.User;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public List<TeacherResponse> getAllTeachers() {
        return teacherMapper.toResponseList(teacherRepository.findAll());
    }

    public TeacherResponse getTeacherById(UUID id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return teacherMapper.toResponse(teacher);
    }

     public TeacherResponse getTeacherByUserId(UUID userId) {
        Teacher teacher = teacherRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Teacher not found with userId: " + userId));
        return teacherMapper.toResponse(teacher);
    }

    public TeacherResponse createTeacher(CreateTeacherRequest request) {
        Teacher teacher = new Teacher();
        User user = new User();
        user.setId(parseUuid(request.userId()));
        teacher.setUser(user);
        teacher.setBio(request.bio());
        teacher.setProfilePictureUrl(request.profilePictureUrl());
        teacher.setTimezone(request.timezone());
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toResponse(savedTeacher);
    }

    public TeacherResponse updateTeacher(UUID id, CreateTeacherRequest request) {
        Teacher teacher = teacherRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        if (request.userId() != null) {
            User user = new User();
            user.setId(parseUuid(request.userId()));
            teacher.setUser(user);
        }
        if (request.bio() != null) {
            teacher.setBio(request.bio());
        }
        if (request.profilePictureUrl() != null) {
            teacher.setProfilePictureUrl(request.profilePictureUrl());
        }
        if (request.timezone() != null) {
            teacher.setTimezone(request.timezone());
        }
        Teacher updatedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toResponse(updatedTeacher);
    }

     public void deleteByUserId(UUID userId) {
        teacherRepository.deleteByUserId(userId);
    }

     public Integer countActiveTeachers() {
        return teacherRepository.countByIsActiveTrue();
    }

    private UUID parseUuid(String id) {
        return UUID.fromString(id);
    }

}
