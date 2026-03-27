package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

public record UpdateExerciseOptionsRequest(
    String text,
    Boolean isCorrect
) {}
