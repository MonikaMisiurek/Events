package com.example.serwisagregujacy.repository;

import com.example.serwisagregujacy.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {
}
