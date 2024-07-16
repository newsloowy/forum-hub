package me.sloowy.forumhub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.sloowy.forumhub.domain.topic.TopicService;
import me.sloowy.forumhub.domain.topic.dto.TopicDTOCreate;
import me.sloowy.forumhub.domain.topic.dto.TopicDTOPagination;
import me.sloowy.forumhub.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid TopicDTOCreate topicDTO,
                                    @AuthenticationPrincipal User user,
                                    UriComponentsBuilder componentsBuilder) {
        var topic = topicService.register(user, topicDTO);
        var uri = componentsBuilder.path("/topics/{id}").buildAndExpand(topic.id()).toUri();

        return ResponseEntity.created(uri).body(topic);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDTOPagination>> list(@PageableDefault(size = 10, sort = {"creation_date"},
            direction = Sort.Direction.DESC) Pageable pagination) {
        var page = topicService.list(pagination);

        return ResponseEntity.ok(page);
    }
}
