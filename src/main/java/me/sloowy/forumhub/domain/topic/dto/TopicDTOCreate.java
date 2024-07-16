package me.sloowy.forumhub.domain.topic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TopicDTOCreate(
        @NotEmpty
        String title,
        @NotEmpty
        String message,
        @JsonProperty(value = "course_id")
        @NotNull
        Long courseId) {
}
