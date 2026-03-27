package io.github.mattheusffalbuquerque.duma.domains.exercice.dto;

import java.util.List;

public record CreateExerciseRequest(

    String lessonId,
    String description,
    String type,
    List<CreateExerciseOptionsRequest> options

) {}
