package voblaweb.photo.controller;

import voblaweb.photo.model.Kiosks;
import voblaweb.photo.model.OfficeOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voblaweb.photo.model.PhotoGoods;
import voblaweb.photo.service.officeorders.OfficeOrdersService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OfficeOrdersController {
    @Autowired
    OfficeOrdersService service;

    @RequestMapping("/office_orders")
    public List<OfficeOrders> getAll(){
        return service.getAll();
    }

    @RequestMapping("/office_orders/get")
    public OfficeOrders getById(@RequestParam int id){
        return service.getById(id);
    }

    @RequestMapping("/office_orders/insert")
    public OfficeOrders insert(@RequestParam int photoGoodId, int kioskId, Date dateOfSupply, int amountOfGoods,
                               int price, Date dateOfSelling) {
        PhotoGoods photoGood = new PhotoGoods();
        photoGood.setId(photoGoodId);
        Kiosks kiosks = new Kiosks();
        kiosks.setId(kioskId);
        OfficeOrders officeOrders = new OfficeOrders(photoGood, kiosks, dateOfSupply, amountOfGoods, price, dateOfSelling);
        return service.insert(officeOrders);
    }

    @RequestMapping("/office_orders/update")
    public OfficeOrders updateCall(@RequestParam int id, int photoGoodId, int kioskId, Date dateOfSupply, int amountOfGoods,
                                   int price, Date dateOfSelling) {
        PhotoGoods photoGood = new PhotoGoods();
        photoGood.setId(photoGoodId);
        Kiosks kiosks = new Kiosks();
        kiosks.setId(kioskId);
        OfficeOrders officeOrders = new OfficeOrders(photoGood, kiosks, dateOfSupply, amountOfGoods, price, dateOfSelling);
        officeOrders.setId(id);
        return service.update(officeOrders);
    }

    @RequestMapping("/office_orders/del")
    public void delete(@RequestParam int id){
        service.delete(id);
    }

    /**QUERIES**/

    @RequestMapping("/office_orders/get_by_photo_good")
    public List<OfficeOrders> getOfficeOrdersByPhotoGoodIdAndDate(@RequestParam int id, Date firstDate, Date secondDate) {
        return service.getOfficeOrdersByPhotoGoodIdAndDate(id, firstDate, secondDate);
    }

//    @RequestMapping("/office_orders/get_by_date")
//    public List<OfficeOrders> getOfficeOrdersByDate(@RequestParam Date firstDate, Date secondDate) {
//        return service.getOfficeOrdersByDate(firstDate, secondDate);
//    }
}
