package com.example.taller5programacion2.jpa.repositories;

import com.example.taller5programacion2.jpa.entities.Pet;
import com.example.taller5programacion2.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {

    Optional<Visit> findById(Integer visit_id);

    List<Visit> findAll();

    Optional<Visit> save(Visit visit);
}
