package voblaweb.photo.controller;

import voblaweb.photo.model.Branches;
import voblaweb.photo.model.Clients;
import voblaweb.photo.service.clients.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientsController {
    @Autowired
    ClientsService service;

    @RequestMapping("/clients")
    public List<Clients> getAll() {
        return service.getAll();
    }

    @RequestMapping("/clients/get")
    public Clients getById(@RequestParam int id) {
        return service.getById(id);
    }

    @RequestMapping("/clients/insert")
    public Clients insert(@RequestParam String name, int branchId, String type, int discount) {
        Branches branches = new Branches();
        branches.setId(branchId);
        Clients client = new Clients(name, branches, type, discount);
        return service.insert(client);
    }

    @RequestMapping("/clients/update")
    public Clients updateCall(@RequestParam int id, String name, int branchId, String type, int discount) {
        Branches branches = new Branches();
        branches.setId(branchId);
        Clients client = new Clients(name, branches, type, discount);
        client.setId(id);
        return service.update(client);
    }

    @RequestMapping("/clients/del")
    public void delete(@RequestParam int id) {
        service.delete(id);
    }

    @RequestMapping("/clients/get_by_branch")
    public List<Clients> getClientsByBranchId(@RequestParam int id) {
        return service.getClientsByBranchId(id);
    }

    @RequestMapping("/clients/get_by_type")
    public List<Clients> getClientsByType(@RequestParam String kType) {
        return service.getClientsByType(kType);
    }

    @RequestMapping("/clients/get_by_discount")
    public List<Clients> getClientsByDiscount(@RequestParam int kFirst, int kLast) {
        return service.getClientsByDiscount(kFirst, kLast);
    }
}