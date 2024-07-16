package me.sloowy.forumhub.domain.answer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.sloowy.forumhub.domain.answer.Answer;

import java.time.LocalDateTime;

public record AnswerDTOPagination(
        Long id,
        String message,
        String solution,
        String user,
        @JsonProperty("creation_date")LocalDateTime creationDate,
        @JsonProperty("topic_id") Long topicId) {

    public AnswerDTOPagination(Answer answer) {
        this(answer.getId(), answer.getMessage(), answer.getSolution(), answer.getUser().getName(), answer.getCreationDate(), answer.getTopic().getId());
    }
}
