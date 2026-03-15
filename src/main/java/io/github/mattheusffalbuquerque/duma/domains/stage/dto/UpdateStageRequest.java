package io.github.mattheusffalbuquerque.duma.domains.stage.dto;

public record UpdateStageRequest(

    String name,
    String slug,
    String shortDescription,
    String fullDescription,
    String iconUrl,
    Boolean isActive

) {}
