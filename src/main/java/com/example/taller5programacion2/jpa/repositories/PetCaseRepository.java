package com.example.taller5programacion2.jpa.repositories;

import com.example.taller5programacion2.jpa.entities.PetCase;

import java.util.List;
import java.util.Optional;

public interface PetCaseRepository {

    Optional<PetCase> findById(Integer id);

    List<PetCase> findAll();

    Optional<PetCase> save(PetCase petcase);
}
