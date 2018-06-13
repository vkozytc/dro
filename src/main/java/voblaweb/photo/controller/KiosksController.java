package voblaweb.photo.controller;

import voblaweb.photo.model.Branches;
import voblaweb.photo.model.Kiosks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voblaweb.photo.service.kiosks.KiosksService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KiosksController {
    @Autowired
    KiosksService service;

    @RequestMapping("/kiosks")
    public List<Kiosks> getAll(){
        return service.getAll();
    }

    @RequestMapping("/kiosks/get")
    public Kiosks getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/kiosks/insert")
    public Kiosks insert(@RequestParam String address, int amountOfWorkplaces, int branchId) {
        Branches branches = new Branches();
        branches.setId(branchId);
        Kiosks kiosks = new Kiosks(address, amountOfWorkplaces, branches);
        return service.insert(kiosks);
    }

    @RequestMapping("/kiosks/update")
    public Kiosks updateCall(@RequestParam int id, String address, int amountOfWorkplaces, int branchId) {
        Branches branches = new Branches();
        branches.setId(branchId);
        Kiosks kiosks = new Kiosks(address, amountOfWorkplaces, branches);
        kiosks.setId(id);
        return service.update(kiosks);
    }

    @RequestMapping("/kiosks/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/kiosks/get_by_branch")
    public List<Kiosks> getKiosksByBranchId(@RequestParam int id){
        return service.getKiosksByBranchId(id);
    }

    @RequestMapping("/kiosks/get_by_workplaces")
    public List<Kiosks> getKiosksByWorkplaces(@RequestParam int firstAmount, int lastAmount){
        return service.getKiosksByWorkplaces(firstAmount, lastAmount);
    }
}
