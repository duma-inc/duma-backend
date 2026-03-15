package io.github.mattheusffalbuquerque.duma.domains.module.dto;

public record UpdateModuleRequest(

    String title,
    String description,
    Integer orderIndex,
    Boolean isActive,
    Long stageId,
    Long skillId

) {}
