package com.example.taller5programacion2.jpa.repositories;

import com.example.taller5programacion2.jpa.entities.Owner;
import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    List<Owner> findAll();

    Optional<Owner> save(Owner book);

}