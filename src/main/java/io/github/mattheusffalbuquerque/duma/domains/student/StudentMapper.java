package io.github.mattheusffalbuquerque.duma.domains.student;

import java.util.List;

import io.github.mattheusffalbuquerque.duma.domains.student.dto.CreateStudentRequest;
import io.github.mattheusffalbuquerque.duma.domains.student.dto.StudentResponse;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    public Student toEntity(CreateStudentRequest student);

    public StudentResponse toResponse(Student student);

    public List<StudentResponse> toResponseList(List<Student> students);

} 