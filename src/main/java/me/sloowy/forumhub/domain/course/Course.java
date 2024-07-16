package me.sloowy.forumhub.domain.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sloowy.forumhub.domain.course.dto.CourseDTO;
import me.sloowy.forumhub.domain.topic.Topic;

import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Topic> topics;

    public Course(CourseDTO courseDTO) {
        this.name = courseDTO.name();
        this.category = courseDTO.category();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
