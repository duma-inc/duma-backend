package io.github.mattheusffalbuquerque.duma.domains.skill.dto;

import java.time.LocalDateTime;

public record UpdateSkillRequest(

    String name,
    String slug,
    String shortDescription,
    String fullDescription,
    Long categoryId,
    String iconUrl,
    Boolean isActive,
    LocalDateTime updatedAt

) {}