package de.nadu_ocholt.anbauplaner.application.user.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
        @NotBlank String username,
        @NotBlank String emailAddress,
        @NotBlank String password
) {
}
