package io.github.mattheusffalbuquerque.duma.domains.student.dto;

import io.github.mattheusffalbuquerque.duma.domains.user.dto.UserResponse;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "StudentResponse", description = "Response containing student details")
public record StudentResponse(

    @Schema(description = "The user data")
    UserResponse user,
    @Schema(description = "The biography", example = "Experienced instructor in backend development")
    String bio,
    @Schema(description = "The profile picture URL", example = "https://example.com/profile.png")
    String profilePictureUrl

) {
}
