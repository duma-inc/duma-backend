package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateExerciseRequest", description = "Request to update an existing Exercise")
public record UpdateExerciseRequest(

    @Schema(description = "The identifier of the lesson", example = "lesson-123")
    String lessonId,
    @Schema(description = "The description", example = "Detailed description of the item")
    String description,
    @Schema(description = "The type of the exercise", example = "MULTIPLE_CHOICE")
    String type,
    @Schema(description = "The available options")
    List<ExerciseOptionsResponse> options

) {}
