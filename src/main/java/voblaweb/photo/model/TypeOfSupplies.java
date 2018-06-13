package voblaweb.photo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "type_of_supplies")
@EntityListeners(AuditingEntityListener.class)
public class TypeOfSupplies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public TypeOfSupplies(String name) {
        this.name = name;
    }

    public TypeOfSupplies() {
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
}
