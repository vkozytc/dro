package voblaweb.photo.controller;

import voblaweb.photo.model.Branches;
import voblaweb.photo.service.branches.BranchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchesController {
    @Autowired
    BranchesService service;

    @RequestMapping("/branches")
    public List<Branches> getAll(){
        return service.getAll();
    }

    @RequestMapping("/branches/get")
    public Branches getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/branches/insert")
    public Branches insert(@RequestParam String address, int amountOfWorkplaces) {
        Branches branches = new Branches(address, amountOfWorkplaces);
        return service.insert(branches);
    }

    @RequestMapping("/branches/update")
    public Branches updateCall(@RequestParam int id, String address, int amountOfWorkplaces) {
        Branches branches = new Branches(address, amountOfWorkplaces);
        branches.setId(id);
        return service.update(branches);
    }

    @RequestMapping("/branches/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    @RequestMapping("/branches/get_by_workplaces")
    public List<Branches> getBranchesByWorkplaces(@RequestParam int firstAmount, int lastAmount){
        return service.getBranchesByWorkplaces(firstAmount, lastAmount);
    }
}
