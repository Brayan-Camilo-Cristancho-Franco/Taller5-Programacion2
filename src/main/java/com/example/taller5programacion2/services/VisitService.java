package com.example.taller5programacion2.services;

import com.example.taller5programacion2.jpa.entities.Pet;
import com.example.taller5programacion2.jpa.entities.Visit;
import com.example.taller5programacion2.jpa.repositories.PetRepository;
import com.example.taller5programacion2.jpa.repositories.PetRepositoryImpl;
import com.example.taller5programacion2.jpa.repositories.VisitRepository;
import com.example.taller5programacion2.jpa.repositories.VisitRepositoryImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.print.Book;
import java.util.Date;
import java.util.Optional;



@Stateless
public class VisitService {
    VisitRepository visitRepository;
    PetRepository petRepository;

    public void saveVisit(Date created_at, String type, String description,Integer pet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        petRepository= new PetRepositoryImpl(entityManager);

        Optional<Pet> pet = petRepository.findById(pet_id);
        pet.ifPresent(p -> {
            p.addVisit(new Visit(created_at,type,description));
            petRepository.save(p);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }
}
