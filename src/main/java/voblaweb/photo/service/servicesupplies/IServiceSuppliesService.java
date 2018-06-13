package voblaweb.photo.service.servicesupplies;

import voblaweb.photo.model.ServiceSupplies;

import java.util.List;

public interface IServiceSuppliesService {
    List<ServiceSupplies> getAll();
    ServiceSupplies insert(ServiceSupplies serviceSupplies);
    ServiceSupplies update(ServiceSupplies serviceSupplies);
    ServiceSupplies getById(int id);
    void delete(int id);
}
