package com.example.serwisagregujacy.model;

import com.example.serwisagregujacy.dto.UserDTO;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private UserLevel role = UserLevel.USER;

    @ManyToMany
    @JoinTable(
            name = "user_enrolled_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Set<Events> events = new HashSet<>();




    public static User from(UserDTO user) {
        return new User(user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.getRole(), user.getEvents());
    }

    public UserDTO toDto() {
        return new UserDTO(getId(), getName(), getPassword(), getEmail(), getRole(), getEvents());
    }
    /*@OneToOne()
    private Account account; to nie
    relacja do enuma z rolą, nie do account, bo bedzie powtorzenie enrolled events*/
}