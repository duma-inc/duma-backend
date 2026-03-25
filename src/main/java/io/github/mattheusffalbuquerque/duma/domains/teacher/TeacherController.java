package io.github.mattheusffalbuquerque.duma.domains.teacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.ResponseEntity;
import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.TeacherResponse;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.CreateTeacherRequest;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getTeacherById(@PathVariable String id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody CreateTeacherRequest request) {
        Teacher teacher = teacherMapper.toEntity(request);
        teacherService.createTeacher(teacher);
        return ResponseEntity.ok(teacherMapper.toResponse(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> updateTeacher(@PathVariable String id, @RequestBody CreateTeacherRequest request) {
        Teacher teacher = teacherMapper.toEntity(request);
        teacher.setId(id);
        TeacherResponse response = teacherService.updateTeacher(teacher);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String id) {
        teacherService.deleteByUserId(id);
        return ResponseEntity.noContent().build();
    }

}
