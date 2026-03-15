package io.github.mattheusffalbuquerque.duma.domains.user.dto;

import java.time.LocalDate;
import io.github.mattheusffalbuquerque.duma.domains.user.UserRoles;

public record CreateUserRequest (
    
    String name,
    String email,
    String password,
    UserRoles role,
    String phone,
    LocalDate birthDate

) {}
