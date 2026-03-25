package io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto;

import java.time.LocalDateTime;

import io.github.mattheusffalbuquerque.duma.domains.lessonProgress.enums.LessonProgressStatus;

public record CreateLessonProgressRequest(

    String studentId,
    String lessonId,
    LessonProgressStatus status,
    Integer progressPercent,
    Integer watchedMinutes,
    LocalDateTime startedAt,
    LocalDateTime lastAccessAt,
    LocalDateTime completedAt

) {}
