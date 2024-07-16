package me.sloowy.forumhub.domain.profile.validation;

import jakarta.validation.ValidationException;
import me.sloowy.forumhub.domain.profile.Profile;
import me.sloowy.forumhub.domain.profile.ProfileRepository;
import me.sloowy.forumhub.domain.profile.dto.ProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfileValidation {

    @Autowired
    private ProfileRepository profileRepository;

    public void validate(ProfileDTO profileDTO) {
        Optional<Profile> profile = profileRepository.findByName(profileDTO.name());
        if (profile.isPresent()) {
            throw new ValidationException("Já existe um perfil com esse nome.");
        }
    }
}
