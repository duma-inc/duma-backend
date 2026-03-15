package io.github.mattheusffalbuquerque.duma.domains.stage.dto;

public record CreateStageRequest(

    String name,
    String slug,
    String shortDescription,
    String fullDescription,
    String iconUrl

) {}  

