package me.sloowy.forumhub.domain.user;

import me.sloowy.forumhub.domain.profile.ProfileRepository;
import me.sloowy.forumhub.domain.user.dto.UserDTOCreate;
import me.sloowy.forumhub.domain.user.dto.UserDTOPagination;
import me.sloowy.forumhub.domain.user.validation.UserValidation;
import me.sloowy.forumhub.domain.user.validation.UserValidationUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private List<UserValidation> userValidation;

    @Autowired
    private List<UserValidationUpdate> userValidationUpdate;

    public UserDTOPagination register(UserDTOCreate userDTO) {
        userValidation.forEach(d -> d.validate(userDTO));

        var profile = profileRepository.getReferenceById(2L);
        var passEncoder = passwordEncoder.encode(userDTO.password());
        var user = new User(userDTO, passEncoder, profile);

        userRepository.save(user);
        return new UserDTOPagination(user);
    }
}
