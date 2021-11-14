package com.example.taller5programacion2.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "UserApp") // Optional
@NamedQueries({
        @NamedQuery(name = "UserApp.findByUsername",
                query = "SELECT a FROM UserApp a WHERE a.username = :username")
})

public class UserApp {

    @Id
    @GeneratedValue
    @Column(name = "username")
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "rol",nullable = false)
    private String rol;

    // FetchType.EAGER: When we retrieve a Library, we'll also automatically retrieve all of its corresponding Books
    // CascadeType.ALL: Propagates all operations from Author to Books
    @OneToOne(mappedBy = "userapp")
    private Official official;

    @OneToOne(mappedBy = "userapp")
    private Owner owner;

    @OneToOne(mappedBy = "userapp")
    private Vet vet;

    public UserApp() {}

    public UserApp(String password, String email, String rol) {
        this.password = password;
        this.email = email;
        this.rol = rol;

    }

    public UserApp(String username, String password, String email, String rol) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }



    public void addOfficial(Official official) {
        this.official = official;
        official.setUserapp(this);

    }

    public void addOwner(Owner owner) {
        this.owner = owner;
        owner.setUserapp(this);

    }

    public void addVet(Vet vet) {
        this.vet = vet;
        vet.setUserapp(this);

    }
}