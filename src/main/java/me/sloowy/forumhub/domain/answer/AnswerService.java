package me.sloowy.forumhub.domain.answer;

import jakarta.validation.ValidationException;
import me.sloowy.forumhub.domain.answer.dto.AnswerDTO;
import me.sloowy.forumhub.domain.answer.dto.AnswerDTOPagination;
import me.sloowy.forumhub.domain.answer.validation.AnswerValidation;
import me.sloowy.forumhub.domain.topic.StatusType;
import me.sloowy.forumhub.domain.topic.TopicRepository;
import me.sloowy.forumhub.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    List<AnswerValidation> answerValidation;

    public AnswerDTOPagination register(AnswerDTO answerDTO, Long topicId, User user) {
        var answerDTOA = new AnswerDTO(answerDTO.message(), topicId, answerDTO.solution());
        answerValidation.forEach(d -> d.validate(answerDTOA));
        var topic = topicRepository.getReferenceById(answerDTOA.topicId());
        if (topic.getStatus().equals(StatusType.SOLVED)) {
            throw new ValidationException("Não é possível cadastrar novas respostas para um tópico já solucionado.");
        }
        var answer = new Answer(answerDTOA);
        answerRepository.save(answer);

        if (topic.getStatus().equals(StatusType.NOT_ANSWERED)) {
            topic.setStatus(StatusType.ANSWERED);
        }

        return new AnswerDTOPagination(answer);
    }

    public Page<AnswerDTOPagination> list(Pageable pagination, Long topicId) {
        if (topicRepository.existsById(topicId)) {
            return answerRepository.findAllAnswers(topicId, pagination).map(AnswerDTOPagination::new);
        }
        throw new ValidationException("Id do tópico informado não existe.");
    }
}
