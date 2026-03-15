package io.github.mattheusffalbuquerque.duma.domains.lessons.dto;
public record CreateLessonRequest(

    String title,
    String content,
    Integer orderIndex,
    Boolean isActive,
    Long moduleId,
    Long stageId,
    Long skillId

) {}