package me.sloowy.forumhub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import me.sloowy.forumhub.domain.profile.Profile;
import me.sloowy.forumhub.domain.profile.ProfileService;
import me.sloowy.forumhub.domain.profile.dto.ProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/profile")
@Secured("ROLE_ADM")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ProfileDTO profileDTO, UriComponentsBuilder componentsBuilder) {
        var profile = profileService.register(profileDTO);
        var uri = componentsBuilder.path("/profile/{id}").buildAndExpand(profile.getId()).toUri();

        return ResponseEntity.created(uri).body(new Profile(profileDTO));
    }
}
