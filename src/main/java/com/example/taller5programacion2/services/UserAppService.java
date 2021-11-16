package com.example.taller5programacion2.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import com.example.taller5programacion2.jpa.entities.UserApp;
import com.example.taller5programacion2.jpa.entities.resources.pojos.UserAppPojo;
import com.example.taller5programacion2.jpa.repositories.UserAppRepository;
import com.example.taller5programacion2.jpa.repositories.UserAppRepositoryImpl;

@Stateless

public class UserAppService {


    UserAppRepository userappRepository;

    public List<UserAppPojo> listUsersApp() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserAppRepositoryImpl(entityManager);
        List<UserApp> usersapp = userappRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<UserAppPojo> usersappPOJO = new ArrayList<>();
        for (UserApp userapp : usersapp) {
            usersappPOJO.add(new UserAppPojo(
                    userapp.getUsername(),
                    userapp.getPassword(),
                    userapp.getEmail(),
                    userapp.getRol()
            ));
        }

        return usersappPOJO;

    }

    public UserApp saveUserApp(String username,String password, String email, String role)  {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserAppRepositoryImpl(entityManager);

        UserApp userapp = new UserApp(username, password, email,role);
        UserApp persistedUserApp = userappRepository.save(userapp).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedUserApp;

    }

    public void updateUserApp(String username, String email) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserAppRepositoryImpl(entityManager);
        userappRepository.update(username,email);

        entityManager.close();
        entityManagerFactory.close();

    }

}