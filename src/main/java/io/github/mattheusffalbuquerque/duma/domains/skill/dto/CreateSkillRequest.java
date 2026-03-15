package io.github.mattheusffalbuquerque.duma.domains.skill.dto;

public record CreateSkillRequest (

    String name,
    String slug,
    String shortDescription,
    String fullDescription,
    Long categoryId,
    String iconUrl

) {}
