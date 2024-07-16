package me.sloowy.forumhub.domain.answer.validation;

import me.sloowy.forumhub.domain.answer.dto.AnswerDTO;

public interface AnswerValidation {

    void validate(AnswerDTO answerDTO);
}
