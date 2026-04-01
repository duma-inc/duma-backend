package io.github.mattheusffalbuquerque.duma.domains.user.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UpdateUserRequest", description = "Request to update an existing User")
public record UpdateUserRequest (
    @Schema(description = "The phone number", example = "+123456789")
    String phone,
    @Schema(description = "The birth date", example = "1990-01-01")
    LocalDate birthDate
    
) {}

