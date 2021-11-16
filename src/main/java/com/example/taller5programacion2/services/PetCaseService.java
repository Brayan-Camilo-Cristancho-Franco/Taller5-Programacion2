package com.example.taller5programacion2.services;

import com.example.taller5programacion2.jpa.entities.Pet;
import com.example.taller5programacion2.jpa.entities.PetCase;

import com.example.taller5programacion2.jpa.repositories.PetCaseRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.example.taller5programacion2.jpa.repositories.PetCaseRepositoryImpl;
import com.example.taller5programacion2.jpa.repositories.PetRepository;
import com.example.taller5programacion2.jpa.repositories.PetRepositoryImpl;

import java.util.Date;

import java.util.Optional;

@Stateless
public class PetCaseService {

    PetCaseRepository petCaseRepository;
    PetRepository petRepository;


    public void savePetCase(Date created_at, String type, String description, Integer pet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petCaseRepository = new PetCaseRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);

        Optional<Pet> pet = petRepository.findById(pet_id);
        pet.ifPresent(p -> {
            p.addPetCase(new PetCase(created_at, type, description));
            petRepository.save(p);
        });
        entityManager.close();
        entityManagerFactory.close();

        return;

    }


}
