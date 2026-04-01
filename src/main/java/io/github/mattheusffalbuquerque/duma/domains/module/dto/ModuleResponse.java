package io.github.mattheusffalbuquerque.duma.domains.module.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ModuleResponse", description = "Response containing module details")
public record ModuleResponse(
    
    @Schema(description = "The title", example = "Java Basics")
    String title,
    @Schema(description = "The description", example = "Detailed description of the item")
    String description,
    @Schema(description = "The stage name")
    String stageName,
    @Schema(description = "The skill name")
    String skillName
    
) {} 
