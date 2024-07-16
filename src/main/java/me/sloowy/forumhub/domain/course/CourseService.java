package me.sloowy.forumhub.domain.course;

import jakarta.validation.ValidationException;
import me.sloowy.forumhub.domain.course.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course register(CourseDTO courseDTO) {
        if (courseRepository.findByEqualName(courseDTO.name()).isPresent()) {
            throw new ValidationException("Já existe um curso cadastrado com esse nome.");
        } else {
            Course course = new Course(courseDTO);
            courseRepository.save(course);

            return course;
        }
    }
}
