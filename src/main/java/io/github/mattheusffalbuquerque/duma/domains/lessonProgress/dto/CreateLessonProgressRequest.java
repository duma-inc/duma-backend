package io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto;

import java.time.LocalDateTime;

import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.enums.LessonProgressStatus;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateLessonProgressRequest", description = "Request to create a new Lesson Progress")
public record CreateLessonProgressRequest(

    @Schema(description = "The identifier of the student", example = "student-123")
    String studentId,
    @Schema(description = "The identifier of the lesson", example = "lesson-123")
    String lessonId,
    @Schema(description = "The status", example = "ACTIVE")
    LessonProgressStatus status,
    @Schema(description = "The progress percentage", example = "80")
    Integer progressPercent,
    @Schema(description = "The number of watched minutes", example = "20")
    Integer watchedMinutes,
    @Schema(description = "The date and time when the progress started", example = "2024-01-01T10:00:00")
    LocalDateTime startedAt,
    @Schema(description = "The date and time of the last access", example = "2024-01-02T15:30:00")
    LocalDateTime lastAccessAt,
    @Schema(description = "The date and time when the progress was completed", example = "2024-01-03T18:00:00")
    LocalDateTime completedAt

) {}
