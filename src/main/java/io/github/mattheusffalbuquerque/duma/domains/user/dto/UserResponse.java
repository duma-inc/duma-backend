package io.github.mattheusffalbuquerque.duma.domains.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UserResponse", description = "Response containing user details")
public record UserResponse( 

    @Schema(description = "The name", example = "John Doe")
    String name,
    @Schema(description = "The email address", example = "john.doe@example.com")
    String email,
    @Schema(description = "The phone number", example = "+123456789")
    String phone,
    @Schema(description = "The birth date", example = "1990-01-01")
    LocalDate birthDate,
    @Schema(description = "The creation date and time", example = "2024-01-01T10:00:00")
    LocalDateTime createdAt

) {}
