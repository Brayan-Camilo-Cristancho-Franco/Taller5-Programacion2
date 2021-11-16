package com.example.taller5programacion2.services;

import com.example.taller5programacion2.jpa.entities.Pet;
import com.example.taller5programacion2.jpa.repositories.PetRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;


import com.example.taller5programacion2.jpa.entities.resources.pojos.PetPojo;
import com.example.taller5programacion2.jpa.repositories.PetRepositoryImpl;

import java.util.List;

@Stateless
public class PetService {

    PetRepository PetRepository;

    public List<PetPojo> listPet() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        PetRepository = new PetRepositoryImpl(entityManager);
        List<Pet> pets = PetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetPojo> petsPojo = new ArrayList<>();
        for (Pet pet : pets) {
            petsPojo.add(new PetPojo(
                    pet.getPet_id(),
                    pet.getMicrochip(),
                    pet.getName(),
                    pet.getEspecies(),
                    pet.getRace(),
                    pet.getSize(),
                    pet.getSex(),
                    pet.getPicture(),
                    pet.getOwner().getPerson_id()
            ));
        }

        return petsPojo;

    }

    public Pet savePet(String microchip, String name, String species, String race, String size, String sex, String picture) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        PetRepository = new PetRepositoryImpl(entityManager);

        Pet pet = new Pet(microchip, name, species, race, size, sex, picture);
        Pet persistedPet = PetRepository.save(pet).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedPet;

    }

    public void updatePet(Integer pet_id, String name, String species, String race, String size, String sex, String picture) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        PetRepository = new PetRepositoryImpl(entityManager);
        PetRepository.update(pet_id, name, species, race, size, sex, picture);

        entityManager.close();
        entityManagerFactory.close();

    }
}
