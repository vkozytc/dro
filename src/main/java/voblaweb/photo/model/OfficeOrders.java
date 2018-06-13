package voblaweb.photo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "office_orders")
@EntityListeners(AuditingEntityListener.class)
public class OfficeOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "photoGoodId")
    private PhotoGoods photoGoodId;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "kioskId")
    private Kiosks kioskId;
    private Date dateOfSupply;
    private int amountOfGoods;
    private int price;
    private Date dateOfSelling;

    public OfficeOrders(PhotoGoods photoGoodId, Kiosks kioskId, Date dateOfSupply, int amountOfGoods,
                        int price, Date dateOfSelling) {
        this.photoGoodId = photoGoodId;
        this.kioskId = kioskId;
        this.dateOfSupply = dateOfSupply;
        this.amountOfGoods = amountOfGoods;
        this.price = price;
        this.dateOfSelling = dateOfSelling;
    }

    public OfficeOrders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PhotoGoods getPhotoGoodId() {
        return photoGoodId;
    }

    public void setPhotoGoodId(PhotoGoods photoGoodId) {
        this.photoGoodId = photoGoodId;
    }

    public Kiosks getKioskId() {
        return kioskId;
    }

    public void setKioskId(Kiosks kioskId) {
        this.kioskId = kioskId;
    }

    public Date getDateOfSupply() {
        return dateOfSupply;
    }

    public void setDateOfSupply(Date dateOfSupply) {
        this.dateOfSupply = dateOfSupply;
    }

    public int getAmountOfGoods() {
        return amountOfGoods;
    }

    public void setAmountOfGoods(int amountOfGoods) {
        this.amountOfGoods = amountOfGoods;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateOfSelling() {
        return dateOfSelling;
    }

    public void setDateOfSelling(Date dateOfSelling) {
        this.dateOfSelling = dateOfSelling;
    }
}
