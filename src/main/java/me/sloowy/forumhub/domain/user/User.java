package me.sloowy.forumhub.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sloowy.forumhub.domain.answer.Answer;
import me.sloowy.forumhub.domain.profile.Profile;
import me.sloowy.forumhub.domain.topic.Topic;
import me.sloowy.forumhub.domain.user.dto.UserDTOCreate;
import me.sloowy.forumhub.domain.user.dto.UserDTOUpdate;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Topic> topics;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Answer> answers;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_profiles",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "profile_id", nullable = false))
    private Set<Profile> profiles;

    public User(UserDTOCreate userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
    }

    public User(UserDTOCreate userDTO, String password, Profile profile) {
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = password;
        this.profiles.add(profile);
    }

    public void update(UserDTOUpdate userDTO) {
        if (userDTO.email() != null) {
            this.email = userDTO.email();
        }
        if (userDTO.name() != null) {
            this.name = userDTO.name();
        }
        if (userDTO.password() != null) {
            this.password = userDTO.password();
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }
}
