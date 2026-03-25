package io.github.mattheusffalbuquerque.duma.domains.lesson.dto;

public record LessonResponse(
    
    String id,
    String title,
    String description,
    String stageName,
    String skillName,
    String videoUrl,
    Integer durationInMinutes

) {}