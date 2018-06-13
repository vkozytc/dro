package voblaweb.photo.service.servicesupplies;

import voblaweb.photo.model.ServiceSupplies;
import voblaweb.photo.repository.ServiceSuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSuppliesService implements IServiceSuppliesService {

    @Autowired
    ServiceSuppliesRepository repository;

    @Override
    public List<ServiceSupplies> getAll() {
        return (List<ServiceSupplies>)repository.findAll();
    }

    @Override
    public ServiceSupplies insert(ServiceSupplies serviceSupplies) {
        return repository.save(serviceSupplies);
    }

    @Override
    public ServiceSupplies update(ServiceSupplies serviceSupplies) {
        return repository.save(serviceSupplies);
    }

    @Override
    public ServiceSupplies getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
