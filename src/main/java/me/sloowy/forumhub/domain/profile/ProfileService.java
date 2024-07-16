package me.sloowy.forumhub.domain.profile;

import me.sloowy.forumhub.domain.profile.dto.ProfileDTO;
import me.sloowy.forumhub.domain.profile.validation.ProfileValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileValidation profileValidation;

    public Profile register(ProfileDTO profileDTO) {
        profileValidation.validate(profileDTO);
        Profile profile = new Profile(profileDTO);
        profileRepository.save(profile);

        return profile;
    }
}
