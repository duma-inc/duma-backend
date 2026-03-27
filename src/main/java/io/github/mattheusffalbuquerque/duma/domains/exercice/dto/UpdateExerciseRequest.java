package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

import java.util.List;

public record UpdateExerciseRequest(

    String lessonId,
    String description,
    String type,
    List<ExerciseOptionsResponse> options

) {}
