package voblaweb.photo.service.clients;

import voblaweb.photo.model.Clients;

import java.util.List;

public interface IClientsService {
    List<Clients> getAll();
    Clients insert(Clients clients);
    Clients update(Clients clients);
    Clients getById(int id);
    void delete(int id);
    List<Clients> getClientsByBranchId(int id);
    List<Clients> getClientsByType(String kType);
    List<Clients> getClientsByDiscount(int kFirst, int kLast);
}
