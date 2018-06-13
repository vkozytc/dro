package voblaweb.photo.service.kiosks;

import voblaweb.photo.model.Kiosks;
import voblaweb.photo.repository.KiosksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KiosksService implements IKiosksService {

    @Autowired
    KiosksRepository repository;

    @Override
    public List<Kiosks> getAll() {
        return (List<Kiosks>)repository.findAll();
    }

    @Override
    public Kiosks insert(Kiosks kiosks) {
        return repository.save(kiosks);
    }

    @Override
    public Kiosks update(Kiosks kiosks) {
        return repository.save(kiosks);
    }

    @Override
    public Kiosks getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Kiosks> getKiosksByBranchId(int id) {
        return repository.getKiosksByBranchId(id);
    }
    @Override
    public List<Kiosks> getKiosksByWorkplaces(int firstAmount, int lastAmount) {
        return repository.getKiosksByWorkplaces(firstAmount, lastAmount);
    }
}
