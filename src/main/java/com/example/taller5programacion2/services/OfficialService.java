package com.example.taller5programacion2.services;

import com.example.taller5programacion2.jpa.entities.Official;
import com.example.taller5programacion2.jpa.repositories.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.taller5programacion2.resources.pojos.OfficialPojo;
import com.example.taller5programacion2.resources.pojos.UserAppPojo;

@Stateless

public class OfficialService {
    OfficialRepository officialRepository;

    public List<OfficialPojo> listOfficials() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        List<Official> officials = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OfficialPojo> officialsPojo = new ArrayList<>();
        for (Official official : officials) {
            officialsPojo.add(new OfficialPojo(
                    official.getUsername(),
                    official.getName()
            ));
        }

        return officialsPojo;

    }

    public Official saveOfficial(String username, String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);

        Official offcial = new Official(username, name);
        Official persistedOfficial = officialRepository.save(offcial).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOfficial;

    }

    public Optional<OfficialPojo> updateUserApp(String username, String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Optional<Official> persistedOfficial = officialRepository.update(username, name);

        entityManager.close();
        entityManagerFactory.close();

        return persistedOfficial.map(value -> new OfficialPojo(
                value.getUsername(),
                value.getName()

        ));
    }
}