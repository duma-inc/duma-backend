package io.github.mattheusffalbuquerque.duma.domains.stage.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "StageResponse", description = "Response containing stage details")
public record StageResponse(

    @Schema(description = "The name", example = "John Doe")
    String name,
    @Schema(description = "The slug", example = "java-basics")
    String slug,
    @Schema(description = "The short description", example = "Short description of the item")
    String shortDescription,
    @Schema(description = "The icon URL", example = "https://example.com/icon.png")
    String iconUrl

) {}
