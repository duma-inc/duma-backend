package io.github.mattheusffalbuquerque.duma.domains.lessons.dto;

public record LessonResponse(
    
    String id,
    String title,
    String description,
    String stageName,
    String skillName
    
) {} 