package me.sloowy.forumhub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.sloowy.forumhub.domain.course.Course;
import me.sloowy.forumhub.domain.course.CourseService;
import me.sloowy.forumhub.domain.course.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @Transactional
    @Secured({"ROLE_ADM", "TEACHER"})
    public ResponseEntity register(@RequestBody @Valid CourseDTO courseDTO, UriComponentsBuilder componentsBuilder) {
        Course course = courseService.register(courseDTO);

        var uri = componentsBuilder.path("/course/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(uri).body(new Course(courseDTO));
    }
}
