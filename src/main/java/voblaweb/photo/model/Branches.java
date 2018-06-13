package voblaweb.photo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "branches")
@EntityListeners(AuditingEntityListener.class)
public class Branches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private int amountOfWorkplaces;

    public Branches() {
    }

    public Branches(String address, int amountOfWorkplaces) {
        this.address = address;
        this.amountOfWorkplaces = amountOfWorkplaces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmountOfWorkplaces() {
        return amountOfWorkplaces;
    }

    public void setAmountOfWorkplaces(int amountOfWorkplaces) {
        this.amountOfWorkplaces = amountOfWorkplaces;
    }
}
