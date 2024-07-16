package me.sloowy.forumhub.domain.answer.dto;

import jakarta.validation.constraints.NotEmpty;

public record AnswerDTO(
        @NotEmpty
        String message,
        @NotEmpty
        Long topicId,
        @NotEmpty
        String solution) {
}
