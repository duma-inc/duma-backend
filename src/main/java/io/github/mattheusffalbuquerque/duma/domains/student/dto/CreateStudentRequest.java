package io.github.mattheusffalbuquerque.duma.domains.student.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateStudentRequest", description = "Request to create a new Student")
public record CreateStudentRequest(

    @Schema(description = "The identifier of the user", example = "user-123")
    String userId,  // ← apenas o ID
    @Schema(description = "The biography", example = "Experienced instructor in backend development")
    String bio,
    @Schema(description = "The profile picture URL", example = "https://example.com/profile.png")
    String profilePictureUrl

) {}
