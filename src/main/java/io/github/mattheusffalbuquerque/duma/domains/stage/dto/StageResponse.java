package io.github.mattheusffalbuquerque.duma.domains.stage.dto;

public record StageResponse(

    Long id,
    String name,
    String slug,
    String shortDescription,
    String iconUrl

) {}
