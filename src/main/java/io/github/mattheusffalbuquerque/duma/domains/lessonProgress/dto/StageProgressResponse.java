package io.github.mattheusffalbuquerque.duma.domains.lessonProgress.dto;

import java.math.BigDecimal;

public record StageProgressResponse(
    Integer completedLessons,
    Long moduleId,
    Integer totalLessons,
    BigDecimal progressPercent,
    String status
) {
}   
