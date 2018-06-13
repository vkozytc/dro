package voblaweb.photo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voblaweb.photo.model.GoodType;
import voblaweb.photo.service.goodtype.GoodTypeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GoodTypeController {
    @Autowired
    GoodTypeService service;

    @RequestMapping("/good_type")
    public List<GoodType> getAll(){
        return service.getAll();
    }

    @RequestMapping("/good_type/get")
    public GoodType getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/good_type/insert")
    public GoodType insert(@RequestParam String name) {
        GoodType goodType = new GoodType(name);
        return service.insert(goodType);
    }

    @RequestMapping("/good_type/update")
    public GoodType updateCall(@RequestParam int id, String name) {
        GoodType goodType = new GoodType(name);
        goodType.setId(id);
        return service.update(goodType);
    }

    @RequestMapping("/good_type/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
