package com.example.taller5programacion2.jpa.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visit") // Optional
@NamedQueries({
        @NamedQuery(name = "Visit.findAll",
                query = "SELECT b FROM Visit b")
})
public class Visit {

    @Id
    @GeneratedValue
    @Column(name = "visit_id")
    private Integer visit_id;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "pet_id")
    private Pet pet_id;

    @ManyToOne()
    @JoinColumn(name = "vet")
    private Vet vet;

    public Visit(){}

    public Visit(Date created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public Visit(Integer visit_id, Date created_at, String type, String description, Pet pet_id, Vet vet) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
        this.vet = vet;
    }

    public Integer getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet_id() {
        return pet_id;
    }

    public void setPet_id(Pet pet_id) {
        this.pet_id = pet_id;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
