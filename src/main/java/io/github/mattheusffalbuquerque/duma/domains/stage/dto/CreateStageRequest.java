package io.github.mattheusffalbuquerque.duma.domains.stage.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateStageRequest", description = "Request to create a new Stage")
public record CreateStageRequest(

    @Schema(description = "The name", example = "John Doe")
    String name,
    @Schema(description = "The slug", example = "java-basics")
    String slug,
    @Schema(description = "The short description", example = "Short description of the item")
    String shortDescription,
    @Schema(description = "The full description", example = "Complete description of the item")
    String fullDescription,
    @Schema(description = "The icon URL", example = "https://example.com/icon.png")
    String iconUrl

) {}  

