package io.github.mattheusffalbuquerque.duma.domains.user.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateUserRequest", description = "Request to create a new User")
public record CreateUserRequest (
    @Schema(description = "The name", example = "John Doe")
    String name,
    @Schema(description = "The email address", example = "john.doe@example.com")
    String email,
    @Schema(description = "The phone number", example = "+123456789")
    String phone,
    @Schema(description = "The birth date", example = "1990-01-01")
    LocalDate birthDate
) {}
