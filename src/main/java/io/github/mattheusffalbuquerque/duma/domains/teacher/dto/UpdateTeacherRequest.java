package io.github.mattheusffalbuquerque.duma.domains.teacher.dto;

public record UpdateTeacherRequest(
    String userId,
    String bio,
    String profilePictureUrl,
    String timezone
) {}
