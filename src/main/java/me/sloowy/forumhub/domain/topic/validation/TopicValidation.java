package me.sloowy.forumhub.domain.topic.validation;

import me.sloowy.forumhub.domain.topic.dto.TopicDTOCreate;

public interface TopicValidation {

    void validate(TopicDTOCreate topicDTO);
}
