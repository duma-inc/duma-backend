package io.github.mattheusffalbuquerque.duma.domains.lesson;

import java.util.List;

import org.mapstruct.Mapper;

import io.github.mattheusffalbuquerque.duma.domains.lesson.dto.CreateLessonRequest;
import io.github.mattheusffalbuquerque.duma.domains.lesson.dto.LessonResponse;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonResponse toResponse(Lesson lesson);

    Lesson toEntity(CreateLessonRequest request);

    List<LessonResponse> toResponseList(List<Lesson> lessons);
}
