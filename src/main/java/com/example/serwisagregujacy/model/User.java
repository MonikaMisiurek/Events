package com.example.serwisagregujacy.model;

import com.example.serwisagregujacy.dto.UserDTO;
import lombok.*;

import javax.persistence.*;
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
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    //todo tu zrobić walidacje na @
    @Column(name = "EMAIL")
    private String email;


    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Events> enrolledEvent;
//trzeba zainicjalizowac zmienną

    public static User from(UserDTO user) {
        return new User(user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.getEnrolledEvent());
    }

    public UserDTO toDto() {
        return new UserDTO(getId(), getName(), getPassword(), getEmail(), getEnrolledEvent());
    }
    /*@OneToOne()
    private Account account; to nie

    relacja do enuma z rolą, nie do account, bo bedzie powtorzenie enrolled events*/
}
