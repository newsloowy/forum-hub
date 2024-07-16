package me.sloowy.forumhub.domain.profile.dto;

import jakarta.validation.constraints.NotEmpty;

public record ProfileDTO(
        @NotEmpty
        String name) {
}
