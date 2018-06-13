package voblaweb.photo.service.supplies;

import voblaweb.photo.model.Supplies;
import voblaweb.photo.repository.SuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SuppliesService implements ISuppliesService {

    @Autowired
    SuppliesRepository repository;

    @Override
    public List<Supplies> getAll() {
        return (List<Supplies>)repository.findAll();
    }

    @Override
    public Supplies insert(Supplies supplies) {
        return repository.save(supplies);
    }

    @Override
    public Supplies update(Supplies supplies) {
        return repository.save(supplies);
    }

    @Override
    public Supplies getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Supplies> getSuppliesByKioskId(int id) {
        return repository.getSuppliesByKioskId(id);
    }

    @Override
    public List<Supplies> getSuppliesByDone(String done) {
        return repository.getSuppliesByDone(done);
    }

    @Override
    public List<Supplies> getSuppliesByClientId(int id) {
        return repository.getSuppliesByClientId(id);
    }

    @Override
    public List<Supplies> getSuppliesByDate(Date firstDate, Date secondDate) {
        return repository.getSuppliesByDate(firstDate, secondDate);
    }

    @Override
    public List<Supplies> getSuppliesByType(int id) {
        return repository.getSuppliesByType(id);
    }

    @Override
    public List<Supplies> getSuppliesByTotalAmount(int firstNumber, int secondNumber) {
        return repository.getSuppliesByTotalAmount(firstNumber, secondNumber);
    }
}
