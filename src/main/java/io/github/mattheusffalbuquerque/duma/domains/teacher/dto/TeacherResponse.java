package io.github.mattheusffalbuquerque.duma.domains.teacher.dto;

public record TeacherResponse(
    
    String userId,
    String bio,
    String profilePictureUrl,
    String timezone
    
) {}
