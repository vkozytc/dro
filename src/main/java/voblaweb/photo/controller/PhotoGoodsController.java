package voblaweb.photo.controller;

import voblaweb.photo.model.GoodType;
import voblaweb.photo.model.PhotoGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voblaweb.photo.service.photogoods.PhotoGoodsService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotoGoodsController {
    @Autowired
    PhotoGoodsService service;

    @RequestMapping("/photo_goods")
    public List<PhotoGoods> getAll(){
        return service.getAll();
    }

    @RequestMapping("/photo_goods/get")
    public PhotoGoods getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/photo_goods/insert")
    public PhotoGoods insert(@RequestParam String name, int goodTypeId, String supplierName) {
        GoodType goodType = new GoodType();
        goodType.setId(goodTypeId);
        PhotoGoods photoGoods = new PhotoGoods(name, goodType, supplierName);
        return service.insert(photoGoods);
    }

    @RequestMapping("/photo_goods/update")
    public PhotoGoods updateCall(@RequestParam int id, String name, int goodTypeId, String supplierName) {
        GoodType goodType = new GoodType();
        goodType.setId(goodTypeId);
        PhotoGoods photoGoods = new PhotoGoods(name, goodType, supplierName);
        photoGoods.setId(id);
        return service.update(photoGoods);
    }

    @RequestMapping("/photo_goods/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }
}
