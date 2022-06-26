package com.example.serwisagregujacy.model;

import com.example.serwisagregujacy.dto.EventDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    public Events() {
    }

    public Events(Long id, String name, Date data, String description) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.description = description;
    }

    public static Events from(EventDTO events) {
        return new Events(events.getId(), events.getName(), events.getData(), events.getDescription());
    }

    public EventDTO toDto() {
        return new EventDTO(id, name, data, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
//usunąć getery i setesy dodać lombook
