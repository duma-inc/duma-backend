package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ExerciseOptionsResponse", description = "Response containing exercise options details")
public record ExerciseOptionsResponse(

    @Schema(description = "The identifier of the option", example = "option-123")
    String optionId,
    @Schema(description = "The text", example = "Option text")
    String text,
    @Schema(description = "Indicates whether the answer is correct", example = "true")
    Boolean isCorrect

) {}
