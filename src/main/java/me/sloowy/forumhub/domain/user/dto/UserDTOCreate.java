package me.sloowy.forumhub.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDTOCreate(
        @NotEmpty
        String name,
        @Email
        @NotEmpty
        String email,
        @NotEmpty
        String password) {
}
