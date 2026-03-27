package io.github.mattheusffalbuquerque.duma.domains.attempt.dto;

import java.time.LocalDateTime;

public record AttemptResponse(

    String studentId,
    String lessonId,
    String exerciseId,
    String answerGiven,
    Boolean isCorrect,
    Integer score,
    Integer timeSpentSeconds,
    LocalDateTime createdAt

) {}
