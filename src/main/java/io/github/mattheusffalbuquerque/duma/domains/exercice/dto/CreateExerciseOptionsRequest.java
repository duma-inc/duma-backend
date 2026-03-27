package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

public record CreateExerciseOptionsRequest(

    String text,
    Boolean isCorrect

) {}
