package me.sloowy.forumhub.domain.course.dto;

import jakarta.validation.constraints.NotEmpty;

public record CourseDTO(
        @NotEmpty
        String name,
        @NotEmpty
        String category) {
}
