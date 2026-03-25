package io.github.mattheusffalbuquerque.duma.domains.lesson.dto;

public record UpdateLessonRequest(

    String title,
    String description,
    Integer orderIndex,
    Boolean isActive,
    Long stageId,
    Long skillId

) {}
