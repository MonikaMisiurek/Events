package com.example.serwisagregujacy.model;

import com.example.serwisagregujacy.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"events", "password", "role"})
@ToString(exclude = "events")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "NAME")
    protected String name;
    @Column(name = "PASSWORD")
    protected String password;
    //todo tu zrobić walidacje na @
    @Column(name = "EMAIL")
    protected String email;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private UserLevel role;

    @ManyToMany
    @JoinTable(
            name = "user_enrolled_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Set<Events> events = new HashSet<>();


    public static User from(UserDTO dto) {
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getPassword(),
                dto.getEmail(),
                Optional.ofNullable(dto.getRole()).orElse(UserLevel.USER),
                dto.getEvents()
        );
    }

    public UserDTO toDto() {
        return new UserDTO(getId(), getName(), getPassword(), getEmail(), getRole(), getEvents());
    }

}
