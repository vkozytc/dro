package voblaweb.photo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@EntityListeners(AuditingEntityListener.class)
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "branchId")
    private Branches branchId;
    private String type;
    private int discount;

    public Clients(String name, Branches branchId, String type, int discount) {
        this.name = name;
        this.branchId = branchId;
        this.type = type;
        this.discount = discount;
    }

    public Clients() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branches getBranchId() {
        return branchId;
    }

    public void setBranchId(Branches branchId) {
        this.branchId = branchId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
