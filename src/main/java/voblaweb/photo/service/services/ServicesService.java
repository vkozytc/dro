package voblaweb.photo.service.services;

import voblaweb.photo.model.Services;
import voblaweb.photo.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService implements IServicesService {

    @Autowired
    ServicesRepository repository;

    @Override
    public List<Services> getAll() {
        return (List<Services>)repository.findAll();
    }

    @Override
    public Services insert(Services services) {
        return repository.save(services);
    }

    @Override
    public Services update(Services services) {
        return repository.save(services);
    }

    @Override
    public Services getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
