package me.sloowy.forumhub.domain.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sloowy.forumhub.domain.answer.dto.AnswerDTO;
import me.sloowy.forumhub.domain.topic.Topic;
import me.sloowy.forumhub.domain.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @JsonProperty(value = "topic_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @JsonProperty(value = "creation_date")
    private LocalDateTime creationDate;

    @JsonProperty(value = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String solution;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "solutionAnswer")
    private Topic solutionTopic;

    public Answer(AnswerDTO answerDTO) {
        this.message = answerDTO.message();
        this.topic = topic;
        this.creationDate = LocalDateTime.now();
        this.user = user;
        this.solution = answerDTO.solution();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Topic getTopic() {
        return topic;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public User getUser() {
        return user;
    }

    public String getSolution() {
        return solution;
    }
}
