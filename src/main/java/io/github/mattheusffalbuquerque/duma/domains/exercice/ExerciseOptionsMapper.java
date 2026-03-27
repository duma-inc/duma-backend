package io.github.mattheusffalbuquerque.duma.domains.exercice;

import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.CreateExerciseOptionsRequest;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.ExerciseOptionsResponse;
import io.github.mattheusffalbuquerque.duma.domains.exercice.dto.UpdateExerciseOptionsRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseOptionsMapper {
    
    ExerciseOptionsResponse toResponse(ExerciseOptions options);

    ExerciseOptions toEntity(CreateExerciseOptionsRequest request);

    ExerciseOptions toEntity(UpdateExerciseOptionsRequest request);

    List<ExerciseOptionsResponse> toResponseList(List<ExerciseOptions> options);

}
