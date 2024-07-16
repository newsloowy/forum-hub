package me.sloowy.forumhub.domain.topic;

import me.sloowy.forumhub.domain.answer.AnswerRepository;
import me.sloowy.forumhub.domain.course.CourseRepository;
import me.sloowy.forumhub.domain.topic.dto.TopicDTOCreate;
import me.sloowy.forumhub.domain.topic.dto.TopicDTOPagination;
import me.sloowy.forumhub.domain.topic.validation.TopicValidation;
import me.sloowy.forumhub.domain.topic.validation.TopicValidationUpdate;
import me.sloowy.forumhub.domain.user.User;
import me.sloowy.forumhub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private List<TopicValidation> topicValidation;

    @Autowired
    private List<TopicValidationUpdate> topicValidationUpdate;


    public TopicDTOPagination register(User userAuth, TopicDTOCreate topicDTO) {
        topicValidation.forEach(d -> d.validate(topicDTO));
        var course = courseRepository.getReferenceById(topicDTO.courseId());
        var user = userRepository.getReferenceById(userAuth.getId());
        Topic topic = new Topic(topicDTO, user, course);
        topicRepository.save(topic);

        return new TopicDTOPagination(topic);
    }

    public Page<TopicDTOPagination> list(Pageable pagination) {
        return topicRepository.findAllTopics(pagination).map(TopicDTOPagination::new);
    }
}
