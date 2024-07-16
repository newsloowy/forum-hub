package me.sloowy.forumhub.domain.topic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.sloowy.forumhub.domain.topic.StatusType;
import me.sloowy.forumhub.domain.topic.Topic;

import java.time.LocalDateTime;

public record TopicDTOPagination(
        Long id,
        String title,
        String message,
        @JsonProperty(value = "creation_date") LocalDateTime creationDate,
        @JsonProperty(value = "user_name") String userName,
        StatusType status,
        String course,
        @JsonProperty(value = "answer_count", defaultValue = "Não há respostas") Integer answerCount,
        @JsonProperty(value = "answer_solution_id", defaultValue = "Sem solução especificada") Long answer_id
) {

    public TopicDTOPagination (Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getUser().getName(),
                topic.getStatus(),
                topic.getCourse().getName(),
                topic.getAnswers() == null ? 0 : topic.getAnswers().size(),
                topic.getSolutionAnswer() == null ? null : topic.getSolutionAnswer().getId());
    }

}
