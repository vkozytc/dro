package voblaweb.photo.controller;

import voblaweb.photo.model.Clients;
import voblaweb.photo.model.Kiosks;
import voblaweb.photo.model.Supplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voblaweb.photo.model.TypeOfSupplies;
import voblaweb.photo.service.supplies.SuppliesService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SuppliesController {
    @Autowired
    SuppliesService service;

    @RequestMapping("/supplies")
    public List<Supplies> getAll(){
        return service.getAll();
    }

    @RequestMapping("/supplies/get")
    public Supplies getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/supplies/insert")
    public Supplies insert(@RequestParam int kioskId, int typeOfSupplyId, int price,
                           int amountOfPhotosPerFrame, int totalAmountOfPhotos, String format,
                           String paperType, Date supplyDate, String done, int clientId) {
        Kiosks kiosks = new Kiosks();
        kiosks.setId(kioskId);
        TypeOfSupplies typeOfSupplies = new TypeOfSupplies();
        typeOfSupplies.setId(typeOfSupplyId);
        Clients clients = new Clients();
        clients.setId(clientId);
        Supplies supplies = new Supplies(kiosks, typeOfSupplies, price, amountOfPhotosPerFrame,
                totalAmountOfPhotos, format, paperType, supplyDate, done, clients);
        return service.insert(supplies);
    }

    @RequestMapping("/supplies/update")
    public Supplies updateCall(@RequestParam int id, int kioskId, int typeOfSupplyId, int price,
                                     int amountOfPhotosPerFrame, int totalAmountOfPhotos, String format,
                                     String paperType, Date supplyDate, String done, int clientId) {
        Kiosks kiosks = new Kiosks();
        kiosks.setId(kioskId);
        TypeOfSupplies typeOfSupplies = new TypeOfSupplies();
        typeOfSupplies.setId(typeOfSupplyId);
        Clients clients = new Clients();
        clients.setId(clientId);
        Supplies supplies = new Supplies(kiosks, typeOfSupplies, price, amountOfPhotosPerFrame,
                totalAmountOfPhotos, format, paperType, supplyDate, done, clients);
        supplies.setId(id);
        return service.update(supplies);
    }

    @RequestMapping("/supplies/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    /**QUERIES**/

    @RequestMapping("/supplies/get_by_kiosk")
    public List<Supplies> getSuppliesByKioskId(@RequestParam int id) {
        return service.getSuppliesByKioskId(id);
    }

    @RequestMapping("/supplies/get_by_done")
    public List<Supplies> getSuppliesByDone(@RequestParam String done) {
        return service.getSuppliesByDone(done);
    }

    @RequestMapping("/supplies/get_by_client")
    public List<Supplies> getSuppliesByClientId(@RequestParam int id) {
        return service.getSuppliesByClientId(id);
    }

    @RequestMapping("/supplies/get_by_date")
    public List<Supplies> getSuppliesByDate(@RequestParam Date firstDate, Date secondDate) {
        return service.getSuppliesByDate(firstDate, secondDate);
    }

    @RequestMapping("/supplies/get_by_type")
    public List<Supplies> getSuppliesByType(@RequestParam int id) {
        return service.getSuppliesByType(id);
    }

    @RequestMapping("/supplies/get_by_total_amount")
    public List<Supplies> getSuppliesByTotalAmount(@RequestParam int firstNumber, int secondNumber) {
        return service.getSuppliesByTotalAmount(firstNumber, secondNumber);
    }
}
