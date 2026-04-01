package io.github.mattheusffalbuquerque.duma.domains.teacher.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "TeacherResponse", description = "Response containing teacher details")
public record TeacherResponse(
    
    @Schema(description = "The identifier of the user", example = "user-123")
    String userId,
    @Schema(description = "The biography", example = "Experienced instructor in backend development")
    String bio,
    @Schema(description = "The profile picture URL", example = "https://example.com/profile.png")
    String profilePictureUrl,
    @Schema(description = "The timezone", example = "America/Sao_Paulo")
    String timezone
    
) {}
