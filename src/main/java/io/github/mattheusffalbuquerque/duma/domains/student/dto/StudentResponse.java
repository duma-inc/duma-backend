package io.github.mattheusffalbuquerque.duma.domains.student.dto;

import io.github.mattheusffalbuquerque.duma.domains.user.dto.UserResponse;

public record StudentResponse(

    UserResponse user,
    String bio,
    String profilePictureUrl

) {
}
