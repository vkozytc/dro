package voblaweb.photo.controller;

import voblaweb.photo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voblaweb.photo.service.servicesupplies.ServiceSuppliesService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceSuppliesController {
    @Autowired
    ServiceSuppliesService service;

    @RequestMapping("/service_supplies")
    public List<ServiceSupplies> getAll(){
        return service.getAll();
    }

    @RequestMapping("/service_supplies/get")
    public ServiceSupplies getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/service_supplies/insert")
    public ServiceSupplies insert(@RequestParam Date date, int kioskId, int serviceId, int clientId) {
        Kiosks kiosks = new Kiosks();
        kiosks.setId(kioskId);
        Services services = new Services();
        services.setId(serviceId);
        Clients clients = new Clients();
        clients.setId(clientId);
        ServiceSupplies serviceSupplies = new ServiceSupplies(date, kiosks, services, clients);
        return service.insert(serviceSupplies);
    }

    @RequestMapping("/service_supplies/update")
    public ServiceSupplies updateCall(@RequestParam int id, Date date, int kioskId, int serviceId, int clientId) {
        Kiosks kiosks = new Kiosks();
        kiosks.setId(kioskId);
        Services services = new Services();
        services.setId(serviceId);
        Clients clients = new Clients();
        clients.setId(clientId);
        ServiceSupplies serviceSupplies = new ServiceSupplies(date, kiosks, services, clients);
        serviceSupplies.setId(id);
        return service.update(serviceSupplies);
    }

    @RequestMapping("/service_supplies/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
