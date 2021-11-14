package com.example.taller5programacion2.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pet") // Optional
@NamedQueries({
        @NamedQuery(name = "Pet.findByMicrochip",
                query = "SELECT a FROM Pet a WHERE a.microchip = :name")
})
public class Pet {

    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Integer pet_id;

    @Column(name = "microchip", unique = true)
    private String microchip;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "especies", nullable = false)
    private String especies;

    @Column(name = "name", nullable = false)
    private String race;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "picture", nullable = false)
    private String picture;

    @OneToMany(mappedBy = "pet_id")
    private List<PetCase> Petscase = new ArrayList<>();


    @OneToMany(mappedBy = "pet_id")
    private List<Visit> visits = new ArrayList<>();


    public Pet() {
    }

    public Pet(String microchip, String name, String especies, String race, String size, String sex, String picture) {
        this.microchip = microchip;
        this.name = name;
        this.especies = especies;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    public Pet(Integer pet_id, String microchip, String name, String especies, String race, String size, String sex, String picture, List<PetCase> petscase) {
        this.pet_id = pet_id;
        this.microchip = microchip;
        this.name = name;
        this.especies = especies;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        Petscase = petscase;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecies() {
        return especies;
    }

    public void setEspecies(String especies) {
        this.especies = especies;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<PetCase> getPetscase() {
        return Petscase;
    }

    public void setPetscase(List<PetCase> petscase) {
        Petscase = petscase;
    }

    public void addPetCase(PetCase petcase) {
        Petscase.add(petcase);
        petcase.setPet_id(this);
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setPet_id(this);
    }

}
