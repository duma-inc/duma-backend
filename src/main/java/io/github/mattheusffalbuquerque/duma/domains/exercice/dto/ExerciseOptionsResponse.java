package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

public record ExerciseOptionsResponse(

    String optionId,
    String text,
    Boolean isCorrect

) {}
