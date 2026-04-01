package io.github.mattheusffalbuquerque.duma.domains.lesson.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "LessonResponse", description = "Response containing lesson details")
public record LessonResponse(
    
    @Schema(description = "The title", example = "Java Basics")
    String title,
    @Schema(description = "The description", example = "Detailed description of the item")
    String description,
    @Schema(description = "The stage name")
    String stageName,
    @Schema(description = "The skill name")
    String skillName,
    @Schema(description = "The video URL", example = "https://example.com/video")
    String videoUrl,
    @Schema(description = "The duration in minutes", example = "45")
    Integer durationInMinutes

) {}
