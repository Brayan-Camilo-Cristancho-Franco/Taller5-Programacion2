package com.example.taller5programacion2.services;

import com.example.taller5programacion2.jpa.entities.Owner;
import com.example.taller5programacion2.jpa.entities.UserApp;
import com.example.taller5programacion2.jpa.repositories.OwnerRepository;
import com.example.taller5programacion2.jpa.repositories.OwnerRepositoryImpl;
import com.example.taller5programacion2.jpa.repositories.UserAppRepositoryImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import com.example.taller5programacion2.resources.pojos.OwnerPojo;

@Stateless

public class OwnerService {

    OwnerRepository ownerRepository;

    public List<OwnerPojo> listOwners() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        List<Owner> owners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPojo> ownersPojo = new ArrayList<>();
        for (Owner owner : owners) {
            ownersPojo.add(new OwnerPojo(
                    owner.getUsername(),
                    owner.getPerson_id(),
                    owner.getName(),
                    owner.getAdress(),
                    owner.getNeighborhood()

            ));
        }

        return ownersPojo;

    }

    public Owner saveOwner(String username, String person_id, String name, String adress, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);

        Owner owner = new Owner(username, person_id, name, adress, neighborhood);
        Owner persistedOwner = ownerRepository.save(owner).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;

    }

    public void updateOwner(String username, String name, String addres, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        ownerRepository.update(username, name, addres, neighborhood);

        entityManager.close();
        entityManagerFactory.close();

    }
}