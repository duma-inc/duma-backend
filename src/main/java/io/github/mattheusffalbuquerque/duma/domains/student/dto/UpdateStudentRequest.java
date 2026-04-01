package io.github.mattheusffalbuquerque.duma.domains.student.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateStudentRequest", description = "Request to update an existing Student")
public record UpdateStudentRequest(

    @Schema(description = "The biography", example = "Experienced instructor in backend development")
    String bio,
    @Schema(description = "The profile picture URL", example = "https://example.com/profile.png")
    String profilePictureUrl

) {}
