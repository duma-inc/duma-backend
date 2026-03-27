package io.github.mattheusffalbuquerque.duma.domains.attempt.dto;

public record CreateAttemptRequest(

    String studentId,
    String lessonId,
    String exerciseId,
    String answerGiven,
    Boolean isCorrect,
    Integer score,
    Integer timeSpentSeconds

) {}
