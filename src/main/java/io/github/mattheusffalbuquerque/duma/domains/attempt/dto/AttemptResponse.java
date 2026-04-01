package io.github.mattheusffalbuquerque.duma.domains.attempt.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "AttemptResponse", description = "Response containing attempt details")
public record AttemptResponse(

    @Schema(description = "The identifier of the student", example = "student-123")
    String studentId,
    @Schema(description = "The identifier of the lesson", example = "lesson-123")
    String lessonId,
    @Schema(description = "The identifier of the exercise", example = "exercise-123")
    String exerciseId,
    @Schema(description = "The answer provided by the student", example = "Answer text")
    String answerGiven,
    @Schema(description = "Indicates whether the answer is correct", example = "'true")
    Boolean isCorrect,
    @Schema(description = "The score", example = "85")
    Integer score,
    @Schema(description = "The total time spent in seconds", example = "3600")
    Integer timeSpentSeconds,
    @Schema(description = "The creation date and time", example = "2024-01-01T10:00:00")
    LocalDateTime createdAt

) {}
