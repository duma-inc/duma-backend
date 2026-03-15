package io.github.mattheusffalbuquerque.duma.domains.module.dto;

public record CreateModuleRequest(

    String title,
    String description,
    Integer orderIndex,
    Boolean isActive,
    Long stageId,
    Long skillId

) {}