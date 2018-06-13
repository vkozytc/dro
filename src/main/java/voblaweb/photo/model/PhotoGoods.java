package voblaweb.photo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "photo_goods")
@EntityListeners(AuditingEntityListener.class)
public class PhotoGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "goodTypeId")
    private GoodType goodTypeId;
    private String supplierName;

    public PhotoGoods() {
    }

    public PhotoGoods(String name, GoodType goodTypeId, String supplierName) {
        this.name = name;
        this.goodTypeId = goodTypeId;
        this.supplierName = supplierName;
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

    public GoodType getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(GoodType goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
