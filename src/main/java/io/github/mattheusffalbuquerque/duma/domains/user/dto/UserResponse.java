package io.github.mattheusffalbuquerque.duma.domains.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponse( 

    String id,
    String name,
    String email,
    String phone,
    LocalDate birthDate,
    LocalDateTime createdAt

) {}
