package io.github.mattheusffalbuquerque.duma.domains.teacher.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateTeacherRequest", description = "Request to update an existing Teacher")
public record UpdateTeacherRequest(
    @Schema(description = "The identifier of the user", example = "user-123")
    String userId,
    @Schema(description = "The biography", example = "Experienced instructor in backend development")
    String bio,
    @Schema(description = "The profile picture URL", example = "https://example.com/profile.png")
    String profilePictureUrl,
    @Schema(description = "The timezone", example = "America/Sao_Paulo")
    String timezone
) {}
