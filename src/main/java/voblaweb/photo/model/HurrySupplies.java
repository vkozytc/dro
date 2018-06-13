package voblaweb.photo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hurry_supplies")
@EntityListeners(AuditingEntityListener.class)
public class HurrySupplies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "branchId")
    private Branches branchId;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "typeOfSupplyId")
    private TypeOfSupplies typeOfSupplyId;
    private int price;
    private int amountOfPhotosPerFrame;
    private int totalAmountOfPhotos;
    private String format;
    private String paperType;
    private Date supplyDate;
    private String done;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private Clients clientId;

    public HurrySupplies() {
    }

    public HurrySupplies(Branches branchId, TypeOfSupplies typeOfSupplyId, int price, int amountOfPhotosPerFrame, int totalAmountOfPhotos, String format, String paperType, Date supplyDate, String done, Clients clientId) {
        this.branchId = branchId;
        this.typeOfSupplyId = typeOfSupplyId;
        this.price = price;
        this.amountOfPhotosPerFrame = amountOfPhotosPerFrame;
        this.totalAmountOfPhotos = totalAmountOfPhotos;
        this.format = format;
        this.paperType = paperType;
        this.supplyDate = supplyDate;
        this.done = done;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Branches getBranchId() {
        return branchId;
    }

    public void setBranchId(Branches branchId) {
        this.branchId = branchId;
    }

    public TypeOfSupplies getTypeOfSupplyId() {
        return typeOfSupplyId;
    }

    public void setTypeOfSupplyId(TypeOfSupplies typeOfSupplyId) {
        this.typeOfSupplyId = typeOfSupplyId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmountOfPhotosPerFrame() {
        return amountOfPhotosPerFrame;
    }

    public void setAmountOfPhotosPerFrame(int amountOfPhotosPerFrame) {
        this.amountOfPhotosPerFrame = amountOfPhotosPerFrame;
    }

    public int getTotalAmountOfPhotos() {
        return totalAmountOfPhotos;
    }

    public void setTotalAmountOfPhotos(int totalAmountOfPhotos) {
        this.totalAmountOfPhotos = totalAmountOfPhotos;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }
}
