package voblaweb.photo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "kiosks")
@EntityListeners(AuditingEntityListener.class)
public class Kiosks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private int amountOfWorkplaces;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "branchId")
    private Branches branchId;

    public Kiosks(String address, int amountOfWorkplaces, Branches branchId) {
        this.address = address;
        this.amountOfWorkplaces = amountOfWorkplaces;
        this.branchId = branchId;
    }

    public Kiosks() {
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

    public Branches getBranchId() {
        return branchId;
    }

    public void setBranchId(Branches branchId) {
        this.branchId = branchId;
    }
}
