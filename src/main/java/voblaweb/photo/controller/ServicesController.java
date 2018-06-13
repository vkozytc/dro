package voblaweb.photo.controller;

import voblaweb.photo.model.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voblaweb.photo.service.services.ServicesService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicesController {
    @Autowired
    ServicesService service;

    @RequestMapping("/services")
    public List<Services> getAll(){
        return service.getAll();
    }

    @RequestMapping("/services/get")
    public Services getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/services/insert")
    public Services insert(@RequestParam String name, int price) {
        Services services = new Services(name, price);
        return service.insert(services);
    }

    @RequestMapping("/services/update")
    public Services updateCall(@RequestParam int id, String name, int price) {
        Services services = new Services(name, price);
        services.setId(id);
        return service.update(services);
    }

    @RequestMapping("/services/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
