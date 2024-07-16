package me.sloowy.forumhub.domain.user.validation;

import me.sloowy.forumhub.domain.user.dto.UserDTOUpdate;

public interface UserValidationUpdate {

    void validate(UserDTOUpdate userDTO);
}
