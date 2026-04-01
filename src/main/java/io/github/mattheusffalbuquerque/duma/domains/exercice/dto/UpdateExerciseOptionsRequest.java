package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateExerciseOptionsRequest", description = "Request to update an existing Exercise Options")
public record UpdateExerciseOptionsRequest(
    @Schema(description = "The text", example = "Option text")
    String text,
    @Schema(description = "Indicates whether the answer is correct", example = "true")
    Boolean isCorrect
) {}
