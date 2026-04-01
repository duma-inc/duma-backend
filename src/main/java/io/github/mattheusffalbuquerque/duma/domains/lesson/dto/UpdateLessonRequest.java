package io.github.mattheusffalbuquerque.duma.domains.lesson.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateLessonRequest", description = "Request to update an existing Lesson")
public record UpdateLessonRequest(

    @Schema(description = "The title", example = "Java Basics")
    String title,
    @Schema(description = "The description", example = "Detailed description of the item")
    String description,
    @Schema(description = "The display order index", example = "1")
    Integer orderIndex,
    @Schema(description = "Indicates whether the record is active", example = "true")
    Boolean isActive,
    @Schema(description = "The identifier of the stage", example = "stage-123")
    Long stageId,
    @Schema(description = "The identifier of the skill", example = "skill-123")
    Long skillId,
    @Schema(description = "The video URL", example = "https://example.com/video")
    String videoUrl,
    @Schema(description = "The duration in minutes", example = "45")
    Integer durationInMinutes

) {}
