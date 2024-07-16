package me.sloowy.forumhub.domain.profile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sloowy.forumhub.domain.profile.dto.ProfileDTO;
import me.sloowy.forumhub.domain.user.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "profiles")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "profiles", fetch = FetchType.EAGER)
    private Set<User> users;

    public Profile(ProfileDTO profileDTO) {
        this.name = profileDTO.name();
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
