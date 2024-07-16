package me.sloowy.forumhub.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM courses WHERE name = :name", nativeQuery = true)
    Optional<Course> findByEqualName(@Param("name") String name);
}
