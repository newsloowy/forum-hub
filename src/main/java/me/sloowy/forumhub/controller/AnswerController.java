package me.sloowy.forumhub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.sloowy.forumhub.domain.answer.AnswerService;
import me.sloowy.forumhub.domain.answer.dto.AnswerDTO;
import me.sloowy.forumhub.domain.answer.dto.AnswerDTOPagination;
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
@RequestMapping("topics/{topic_id}/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid AnswerDTO answerDTO,
                                   @PathVariable("topic_id") Long topicId,
                                   @AuthenticationPrincipal User user,
                                   UriComponentsBuilder componentsBuilder)
    {
        var answer = answerService.register(answerDTO, topicId, user);

        var uri = componentsBuilder.path("/answer/{id}").buildAndExpand(answer.id()).toUri();

        return ResponseEntity.created(uri).body(answer);
    }

    @GetMapping
    public ResponseEntity<Page<AnswerDTOPagination>> list(@PageableDefault(size = 10, sort = {"creation_date"},
            direction = Sort.Direction.DESC) Pageable pagination,
            @PathVariable("topic_id") Long topicId)
    {
        var page = answerService.list(pagination, topicId);

        return ResponseEntity.ok(page);
    }
}
