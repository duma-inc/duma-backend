package io.github.mattheusffalbuquerque.duma.domains.attempt;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.mattheusffalbuquerque.duma.domains.attempt.dto.AttemptResponse;
import io.github.mattheusffalbuquerque.duma.domains.attempt.dto.CreateAttemptRequest;
import io.github.mattheusffalbuquerque.duma.domains.lesson.Lesson;
import io.github.mattheusffalbuquerque.duma.domains.student.Student;

@Mapper(componentModel = "spring")
public interface AttemptMapper {

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "lessonId", source = "lesson.id")
    AttemptResponse toResponse(Attempt attempt);

    @Mapping(target = "student", source = "studentId")
    @Mapping(target = "lesson", source = "lessonId")
    Attempt toEntity(CreateAttemptRequest request);

    List<AttemptResponse> toResponseList(List<Attempt> attempts);

    default Student mapStudent(String studentId) {
        if (studentId == null) {
            return null;
        }

        Student student = new Student();
        student.setId(studentId);
        return student;
    }

    default Lesson mapLesson(String lessonId) {
        if (lessonId == null) {
            return null;
        }

        Lesson lesson = new Lesson();
        lesson.setId(lessonId);
        return lesson;
    }
}
