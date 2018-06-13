package voblaweb.photo.service.services;

import voblaweb.photo.model.Services;

import java.util.List;

public interface IServicesService {
    List<Services> getAll();
    Services insert(Services services);
    Services update(Services services);
    Services getById(int id);
    void delete(int id);
}
