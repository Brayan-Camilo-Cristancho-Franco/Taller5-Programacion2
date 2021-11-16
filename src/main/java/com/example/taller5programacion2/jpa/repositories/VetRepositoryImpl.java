package com.example.taller5programacion2.jpa.repositories;

import com.example.taller5programacion2.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VetRepositoryImpl implements  VetRepository {

    private EntityManager entityManager;

    public VetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Vet> findByUsername(String username) {
        Vet vet = entityManager.find(Vet.class, username);
        return vet != null ? Optional.of(vet) : Optional.empty();
    }


    public List<Vet> findAll() {
        return entityManager.createQuery("from Vet").getResultList();
    }


    public Optional<Vet> update(String username, String name, String address, String neighborhood) {
        try {
            entityManager.getTransaction().begin();
            Vet vet = entityManager.find(Vet.class, username);
            vet.setName(name);
            vet.setAdress(address);
            vet.setNeighborhood(neighborhood);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public Optional<Vet> save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}