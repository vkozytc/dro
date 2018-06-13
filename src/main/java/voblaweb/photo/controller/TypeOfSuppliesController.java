package voblaweb.photo.controller;

import voblaweb.photo.model.TypeOfSupplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voblaweb.photo.service.typeofsupplies.TypeOfSuppliesServices;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfSuppliesController {
    @Autowired
    TypeOfSuppliesServices service;

    @RequestMapping("/type_of_supplies")
    public List<TypeOfSupplies> getAll(){
        return service.getAll();
    }

    @RequestMapping("/type_of_supplies/get")
    public TypeOfSupplies getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/type_of_supplies/insert")
    public TypeOfSupplies insert(@RequestParam String name) {
        TypeOfSupplies typeOfSupplies = new TypeOfSupplies(name);
        return service.insert(typeOfSupplies);
    }

    @RequestMapping("/type_of_supplies/update")
    public TypeOfSupplies updateCall(@RequestParam int id, String name) {
        TypeOfSupplies typeOfSupplies = new TypeOfSupplies(name);
        typeOfSupplies.setId(id);
        return service.update(typeOfSupplies);
    }

    @RequestMapping("/type_of_supplies/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
