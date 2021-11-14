import com.example.taller5programacion2.resources.pojos.Visit;

import javax.persistence.*;

@Entity
@Table(name = "vet") // Optional
@NamedQueries({
        @NamedQuery(name = "Vet.findAll",
                query = "SELECT b FROM Vet b")
})
public class Vet {
    @Id
    @GeneratedValue
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;



    @OneToOne
    @JoinColumn(name = "username")
    private UserApp userapp;

    @OneToOne(mappedBy = "vet")
    private Visit visit;

    public Vet (){}

    public Vet (String name, String adress, String neighborhood){
        this.name = name;
        this.adress = adress;
        this.neighborhood = neighborhood;
    }

    public Vet (String username ,String name, String adress, String neighborhood){
        this.username = username;
        this.name = name;
        this.adress = adress;
        this.neighborhood = neighborhood;
    }

    public void addVist(Visit visit) {
        this.visit = visit;
        visit.setVet(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public UserApp getUserapp() {
        return userapp;
    }

    public void setUserapp(UserApp userapp) {
        this.userapp = userapp;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}