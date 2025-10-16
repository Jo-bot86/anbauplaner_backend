package de.nadu_ocholt.anbauplaner.application.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
