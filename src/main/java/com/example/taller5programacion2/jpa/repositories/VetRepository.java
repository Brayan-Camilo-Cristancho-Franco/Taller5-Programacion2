package com.example.taller5programacion2.jpa.repositories;

import com.example.taller5programacion2.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository {

    Optional<Vet> findByUsername(String username);

    Optional<Vet> update(String username, String name, String address, String neighborhood);

    List<Vet> findAll();

    Optional<Vet> save(Vet vet);

}
