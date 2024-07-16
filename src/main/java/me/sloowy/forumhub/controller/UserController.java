package me.sloowy.forumhub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.sloowy.forumhub.domain.user.UserService;
import me.sloowy.forumhub.domain.user.dto.UserDTOCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserDTOCreate userDTO,
                                    UriComponentsBuilder componentsBuilder)
    {
        var user = userService.register(userDTO);
        var uri = componentsBuilder.path("/users/{id}").buildAndExpand(user.id()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
}
