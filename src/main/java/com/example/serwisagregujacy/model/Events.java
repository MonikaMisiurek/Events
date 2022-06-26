package com.example.serwisagregujacy.model;

import com.example.serwisagregujacy.dto.EventDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    public String name;
    @DateTimeFormat(pattern = "yy-MM-dd")
    public Date data;
    @Column(name = "DESCRIPTION")
    public String description;

    @ManyToMany(mappedBy = "Events")
    private Set<User> enrolledUser;


    public static Events from(EventDTO events) {
        return new Events(events.getId(), events.getName(), events.getData(), events.getDescription(), events.getEnrolledUser());
    }

    public EventDTO toDto() {
        return new EventDTO(id, name, data, description, enrolledUser);
    }
}


