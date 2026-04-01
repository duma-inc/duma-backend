package io.github.mattheusffalbuquerque.duma.domains.stage.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateStageRequest", description = "Request to update an existing Stage")
public record UpdateStageRequest(

    @Schema(description = "The name", example = "John Doe")
    String name,
    @Schema(description = "The slug", example = "java-basics")
    String slug,
    @Schema(description = "The short description", example = "Short description of the item")
    String shortDescription,
    @Schema(description = "The full description", example = "Complete description of the item")
    String fullDescription,
    @Schema(description = "The icon URL", example = "https://example.com/icon.png")
    String iconUrl,
    @Schema(description = "Indicates whether the record is active", example = "true/false")
    Boolean isActive

) {}
