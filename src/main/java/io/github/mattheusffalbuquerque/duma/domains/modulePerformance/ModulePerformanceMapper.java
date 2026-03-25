package io.github.mattheusffalbuquerque.duma.domains.modulePerformance;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto.CreateModulePerformanceRequest;
import io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto.ModulePerformanceResponse;

@Mapper(componentModel = "spring")
public interface ModulePerformanceMapper {

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "moduleId", source = "module.id")
    ModulePerformanceResponse toResponse(ModulePerformance modulePerformance);

    ModulePerformance toEntity(CreateModulePerformanceRequest request);

    List<ModulePerformanceResponse> toResponseList(List<ModulePerformance> modulePerformances);
}
