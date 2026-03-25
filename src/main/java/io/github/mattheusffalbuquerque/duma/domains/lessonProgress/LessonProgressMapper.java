package io.github.mattheusffalbuquerque.duma.domains.lessonProgress;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.CreateLessonProgressRequest;
import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto.LessonProgressResponse;

@Mapper(componentModel = "spring")
public interface LessonProgressMapper {

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "lessonId", source = "lesson.id")
    LessonProgressResponse toResponse(LessonProgress lessonProgress);

    LessonProgress toEntity(CreateLessonProgressRequest request);

    List<LessonProgressResponse> toResponseList(List<LessonProgress> lessonProgressList);
}
