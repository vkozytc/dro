package voblaweb.photo.service.hurrysupplies;

import voblaweb.photo.model.HurrySupplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voblaweb.photo.repository.HurrySuppliesRepository;
import voblaweb.photo.service.hurrysupplies.IHurrySuppliesService;

import java.sql.Date;
import java.util.List;

@Service
public class HurrySuppliesService implements IHurrySuppliesService {

    @Autowired
    HurrySuppliesRepository repository;

    @Override
    public List<HurrySupplies> getAll() {
        return (List<HurrySupplies>)repository.findAll();
    }

    @Override
    public HurrySupplies insert(HurrySupplies hurrySupplies) {
        return repository.save(hurrySupplies);
    }

    @Override
    public HurrySupplies update(HurrySupplies hurrySupplies) {
        return repository.save(hurrySupplies);
    }

    @Override
    public HurrySupplies getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<HurrySupplies> getHurrySuppliesByBranchId(int id) {
        return repository.getHurrySuppliesByBranchId(id);
    }

    @Override
    public List<HurrySupplies> getHurrySuppliesByDone(String done) {
        return repository.getHurrySuppliesByDone(done);
    }

    @Override
    public List<HurrySupplies> getHurrySuppliesByClientId(int id) {
        return repository.getHurrySuppliesByClientId(id);
    }

    @Override
    public List<HurrySupplies> getHurrySuppliesByDate(Date firstDate, Date secondDate) {
        return repository.getHurrySuppliesByDate(firstDate, secondDate);
    }

    @Override
    public List<HurrySupplies> getHurrySuppliesByType(int id) {
        return repository.getHurrySuppliesByType(id);
    }

    @Override
    public List<HurrySupplies> getHurrySuppliesByTotalAmount(int firstNumber, int secondNumber) {
        return repository.getHurrySuppliesByTotalAmount(firstNumber, secondNumber);
    }
}
