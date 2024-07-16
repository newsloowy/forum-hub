package me.sloowy.forumhub.domain.topic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.sloowy.forumhub.domain.topic.StatusType;

public record TopicDTOUpdate(
    String title,

    String message,

    StatusType status,

    @JsonProperty(value = "course_id")
    Long courseId,

    @JsonProperty(value = "solution_answer_id", defaultValue = "Tópico ainda sem solução.")
    Long solutionId) {
}
