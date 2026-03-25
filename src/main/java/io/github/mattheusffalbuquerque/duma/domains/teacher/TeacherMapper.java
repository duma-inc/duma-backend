package io.github.mattheusffalbuquerque.duma.domains.teacher;

import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.CreateTeacherRequest;
import io.github.mattheusffalbuquerque.duma.domains.teacher.dto.TeacherResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherResponse toResponse(Teacher teacher);

    Teacher toEntity(CreateTeacherRequest request);

    List<TeacherResponse> toResponseList(List<Teacher> teachers);

}
