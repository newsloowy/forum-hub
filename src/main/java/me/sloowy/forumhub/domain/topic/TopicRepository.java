package me.sloowy.forumhub.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query(value = "SELECT * FROM topics WHERE title = :title", nativeQuery = true)
    Optional<Topic> findByEqualTitle(@Param("title") String title);

    @Query(value = "SELECT * FROM topics WHERE message = :message", nativeQuery = true)
    Optional<Topic> findByEqualMessage(@Param("message") String message);

    @Query(value = "SELECT * FROM topics", nativeQuery = true)
    Page<Topic> findAllTopics(Pageable pagination);
}
