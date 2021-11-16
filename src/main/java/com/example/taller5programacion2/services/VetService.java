package com.example.taller5programacion2.services;

import com.example.taller5programacion2.jpa.entities.UserApp;
import com.example.taller5programacion2.jpa.entities.Vet;
import com.example.taller5programacion2.jpa.repositories.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class VetService {

    VetRepository vetRepository;
    UserAppRepository userAppRepository;

    public void saveVet(String name, String address, String neighborhood,String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);

        Optional<UserApp> userapp = userAppRepository.findByUsername(username);
        userapp.ifPresent(p -> {
            p.addVet(new Vet(name, address,neighborhood));
            userAppRepository.save(p);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }
    public void updateVet(String username, String name, String address, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        vetRepository.update(username,name,address,neighborhood);

        entityManager.close();
        entityManagerFactory.close();

    }
}
