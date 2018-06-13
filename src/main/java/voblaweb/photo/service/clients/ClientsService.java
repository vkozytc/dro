package voblaweb.photo.service.clients;

import voblaweb.photo.model.Clients;
import voblaweb.photo.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService implements IClientsService {

    @Autowired
    ClientsRepository repository;

    @Override
    public List<Clients> getAll() {
        return (List<Clients>)repository.findAll();
    }

    @Override
    public Clients insert(Clients clients) {
        return repository.save(clients);
    }

    @Override
    public Clients update(Clients clients) {
        return repository.save(clients);
    }

    @Override
    public Clients getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Clients> getClientsByBranchId(int id) {
        return repository.getClientsByBranchId(id);
    }

    @Override
    public List<Clients> getClientsByType(String kType) {
        return repository.getClientsByType(kType);
    }

    @Override
    public List<Clients> getClientsByDiscount(int kFirst, int kLast) {
        return repository.getClientsByDiscount(kFirst, kLast);
    }
}
