package io.github.mattheusffalbuquerque.duma.domains.student;

import java.util.List;

import io.github.mattheusffalbuquerque.duma.domains.student.dto.CreateStudentRequest;
import io.github.mattheusffalbuquerque.duma.domains.student.dto.StudentResponse;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    public Student toEntity(CreateStudentRequest student);

    public void toEntity(CreateStudentRequest student, @MappingTarget Student existingStudent);

    public StudentResponse toResponse(Student student);

    public List<StudentResponse> toResponseList(List<Student> students);

} 
