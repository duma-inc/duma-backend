package io.github.mattheusffalbuquerque.duma.domains.teacher.dto;

public record CreateTeacherRequest(
    
    String userId,
    String bio,
    String profilePictureUrl,
    String timezone

) {}
    