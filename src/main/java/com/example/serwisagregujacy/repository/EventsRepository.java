package com.example.serwisagregujacy.repository;

import com.example.serwisagregujacy.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {

    List<Events> findByDataBetweenOrderByDataDesc(Date start, Date end);

}
