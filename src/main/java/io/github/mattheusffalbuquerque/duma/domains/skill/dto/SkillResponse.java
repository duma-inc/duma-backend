package io.github.mattheusffalbuquerque.duma.domains.skill.dto;

public record SkillResponse(

    Long id,
    String name,
    String slug,
    String shortDescription,
    String category

) {}
