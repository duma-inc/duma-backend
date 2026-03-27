package io.github.mattheusffalbuquerque.duma.domains.exercice;

import java.util.List;
import org.mapstruct.Mapper;

import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.CreateExerciseRequest;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.ExerciseResponse;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.UpdateExerciseRequest;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.ExerciseOptionsResponse;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    ExerciseResponse toResponse(Exercise exercise);

    List<ExerciseOptionsResponse> toResponse(List<ExerciseOptions> options);

    Exercise toEntity(CreateExerciseRequest request);

    Exercise toEntity(UpdateExerciseRequest request);

    List<ExerciseOptions> toEntity(List<ExerciseOptionsResponse> options);

    List<ExerciseResponse> toResponseList(List<Exercise> exercises);
}
