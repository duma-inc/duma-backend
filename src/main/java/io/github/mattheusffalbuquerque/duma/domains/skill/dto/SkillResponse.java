package io.github.mattheusffalbuquerque.duma.domains.skill.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "SkillResponse", description = "Response containing skill details")
public record SkillResponse(

    @Schema(description = "The identifier of the record")
    Long id,
    @Schema(description = "The name", example = "John Doe")
    String name,
    @Schema(description = "The slug", example = "java-basics")
    String slug,
    @Schema(description = "The short description", example = "Short description of the item")
    String shortDescription,
    @Schema(description = "The category", example = "General")
    String category

) {}
