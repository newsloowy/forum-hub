package me.sloowy.forumhub.domain.topic.validation;

import me.sloowy.forumhub.domain.topic.dto.TopicDTOUpdate;

public interface TopicValidationUpdate {

    void validate(TopicDTOUpdate topicDTO);
}
