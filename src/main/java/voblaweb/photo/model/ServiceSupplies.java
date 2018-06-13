package voblaweb.photo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "service_supplies")
@EntityListeners(AuditingEntityListener.class)
public class ServiceSupplies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "kioskId")
    private Kiosks kioskId;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "serviceId")
    private Services serviceId;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private Clients clientId;

    public ServiceSupplies() {
    }

    public ServiceSupplies(Date date, Kiosks kioskId, Services serviceId, Clients clientId) {
        this.date = date;
        this.kioskId = kioskId;
        this.serviceId = serviceId;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Kiosks getKioskId() {
        return kioskId;
    }

    public void setKioskId(Kiosks kioskId) {
        this.kioskId = kioskId;
    }

    public Services getServiceId() {
        return serviceId;
    }

    public void setServiceId(Services serviceId) {
        this.serviceId = serviceId;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }
}
