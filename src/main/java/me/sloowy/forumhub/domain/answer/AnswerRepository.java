package me.sloowy.forumhub.domain.answer;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "SELECT * FROM answers WHERE topic_id = :topicId and message = :message", nativeQuery = true)
    Optional<Answer> findByEqualMessage(@Param("topicId") Long topicId, @Param("message") String message);

    @Query(value = "SELECT * FROM answers WHERE topic_id = :topicId and solution = :solution", nativeQuery = true)
    Optional<Answer> findByEqualSolution(@Param("topicId") Long topicId, @Param("solution") String solution);

    @Query(value = "SELECT * FROM answers WHERE topic_id = :topicId", nativeQuery = true)
    Page<Answer> findAllAnswers(@Param("topicId") Long topicId, Pageable pagination);

    @Query(value = "SELECT * FROM answers WHERE topic_id = :topicId and id = :answerId", nativeQuery = true)
    Optional<Answer> findAnswerByTopic(@Param("topicId") Long topicId, @Param("answerId") Long answerId);
}
