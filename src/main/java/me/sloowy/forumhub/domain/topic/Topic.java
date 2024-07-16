package me.sloowy.forumhub.domain.topic;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.sloowy.forumhub.domain.answer.Answer;
import me.sloowy.forumhub.domain.course.Course;
import me.sloowy.forumhub.domain.topic.dto.TopicDTOCreate;
import me.sloowy.forumhub.domain.topic.dto.TopicDTOUpdate;
import me.sloowy.forumhub.domain.user.User;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "topics")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    @JsonProperty(value = "creation_date")
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    @Setter
    private StatusType status;

    @JsonProperty(value = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonProperty(value = "course_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @Setter
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.REMOVE)
    private Set<Answer> answers;

    @JsonProperty(value = "solution_answer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solution_answer_id")
    @Setter
    private Answer solutionAnswer;

    public Topic(TopicDTOCreate topicDTO, User user, Course course) {
        this.title = topicDTO.title();
        this.message = topicDTO.message();
        this.user = user;
        this.course = course;
        this.creationDate = LocalDateTime.now();
        this.status = StatusType.NOT_ANSWERED;
    }

    public void update(TopicDTOUpdate topicDTO) {
        if (topicDTO.title() != null) {
            this.title = topicDTO.title();
        }
        if (topicDTO.message() != null) {
            this.title = topicDTO.title();
        }
        if (topicDTO.status() != null) {
            this.status = topicDTO.status();
        }
    }

    public Long getId() {
        return id;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public Answer getSolutionAnswer() {
        return solutionAnswer;
    }
}
