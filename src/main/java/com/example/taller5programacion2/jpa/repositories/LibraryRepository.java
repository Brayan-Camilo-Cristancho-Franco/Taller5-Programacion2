package com.example.taller5programacion2.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository {

    List<Library> findAll();

    Optional<Library> save(Library library);

}
