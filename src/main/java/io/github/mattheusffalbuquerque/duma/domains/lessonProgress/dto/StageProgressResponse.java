package io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "StageProgressResponse", description = "Response containing stage progress details")
public record StageProgressResponse(
    @Schema(description = "The number of completed lessons", example = "5")
    Integer completedLessons,
    @Schema(description = "The identifier of the module", example = "module-123")
    Long moduleId,
    @Schema(description = "The total number of lessons", example = "8")
    Integer totalLessons,
    @Schema(description = "The progress percentage", example = "80")
    BigDecimal progressPercent,
    @Schema(description = "The status", example = "ACTIVE")
    String status
) {
}   
