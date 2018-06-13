package voblaweb.photo.service.officeorders;

import voblaweb.photo.model.OfficeOrders;
import voblaweb.photo.repository.OfficeOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OfficeOrdersService implements IOfficeOrdersService {

    @Autowired
    OfficeOrdersRepository repository;

    @Override
    public List<OfficeOrders> getAll() {
        return (List<OfficeOrders>)repository.findAll();
    }

    @Override
    public OfficeOrders insert(OfficeOrders officeOrders) {
        return repository.save(officeOrders);
    }

    @Override
    public OfficeOrders update(OfficeOrders officeOrders) {
        return repository.save(officeOrders);
    }

    @Override
    public OfficeOrders getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<OfficeOrders> getOfficeOrdersByPhotoGoodIdAndDate(int id, Date firstDate, Date secondDate) {
        return repository.getOfficeOrdersByPhotoGoodIdAndDate(id, firstDate, secondDate);
    }
}
