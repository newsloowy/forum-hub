package me.sloowy.forumhub.domain.user.validation;

import me.sloowy.forumhub.domain.user.dto.UserDTOCreate;

public interface UserValidation {

    void validate(UserDTOCreate userDTO);
}
