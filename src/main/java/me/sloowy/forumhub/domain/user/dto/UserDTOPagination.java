package me.sloowy.forumhub.domain.user.dto;

import me.sloowy.forumhub.domain.profile.Profile;
import me.sloowy.forumhub.domain.user.User;

import java.util.Set;
import java.util.stream.Collectors;

public record UserDTOPagination(
        Long id,
        String name,
        String email,
        Set<String> profiles
) {
    public UserDTOPagination(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getProfiles().stream().map(Profile::getName).collect(Collectors.toSet()));
    }
}
