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
    protected Long id;
    @Column(name = "NAME")
    protected String name;
    @Column(name = "PASSWORD")
    protected String password;
    //todo tu zrobić walidacje na @
    @Column(name = "EMAIL")
    protected String email;


    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Set<Events> enrolledEvent;
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
