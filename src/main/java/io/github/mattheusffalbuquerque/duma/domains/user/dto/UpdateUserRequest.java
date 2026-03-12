package io.github.mattheusffalbuquerque.duma.domains.user.dto;

import java.time.LocalDate;

public record UpdateUserRequest (
    String name,
    String email,
    String phone,
    LocalDate birthDate
) {}

