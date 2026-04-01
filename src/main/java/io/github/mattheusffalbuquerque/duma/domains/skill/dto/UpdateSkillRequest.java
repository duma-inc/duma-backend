package io.github.mattheusffalbuquerque.duma.domains.skill.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateSkillRequest", description = "Request to update an existing Skill")
public record UpdateSkillRequest(

    @Schema(description = "The name", example = "John Doe")
    String name,
    @Schema(description = "The slug", example = "java-basics")
    String slug,
    @Schema(description = "The short description", example = "Short description of the item")
    String shortDescription,
    @Schema(description = "The full description", example = "Complete description of the item")
    String fullDescription,
    @Schema(description = "The identifier of the category")
    Long categoryId,
    @Schema(description = "The icon URL", example = "https://example.com/icon.png")
    String iconUrl,
    @Schema(description = "Indicates whether the record is active")
    Boolean isActive,
    @Schema(description = "The last update date and time", example = "2024-01-02T12:00:00")
    LocalDateTime updatedAt

) {}
