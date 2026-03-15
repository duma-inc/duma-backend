package io.github.mattheusffalbuquerque.duma.domains.module;

import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.module.dto.CreateModuleRequest;
import io.github.mattheusffalbuquerque.duma.domains.module.dto.ModuleResponse;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    public ModuleResponse toResponse(Module module);

    public Module toEntity(CreateModuleRequest request);

    public List<ModuleResponse> toResponseList(List<Module> modules);

} 
