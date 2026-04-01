package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateExerciseOptionsRequest", description = "Request to create a new Exercise Options")
public record CreateExerciseOptionsRequest(

    @Schema(description = "The text", example = "Option text")
    String text,
    @Schema(description = "Indicates whether the answer is correct", example = "true")
    Boolean isCorrect

) {}
