package io.github.mattheusffalbuquerque.duma.domains.stage;

import io.github.mattheusffalbuquerque.duma.domains.stage.dto.StageResponse;

import java.util.List;

import org.mapstruct.Mapper;
import io.github.mattheusffalbuquerque.duma.domains.stage.dto.CreateStageRequest;

@Mapper(componentModel = "spring")
public interface StageMapper {

    StageResponse toResponse(Stage stage);

    Stage toEntity(CreateStageRequest request);

    List<StageResponse> toResponseList(List<Stage> stages);

}
