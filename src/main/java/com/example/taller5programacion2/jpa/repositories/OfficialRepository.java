package com.example.taller5programacion2.jpa.repositories;


import com.example.taller5programacion2.jpa.entities.Official;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    List<Official> findAll();

    Optional<Official> save(Official author);

}