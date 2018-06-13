package voblaweb.photo.service.branches;

import voblaweb.photo.model.Branches;
import voblaweb.photo.repository.BranchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchesService implements IBranchesService {

    @Autowired
    BranchesRepository repository;

    @Override
    public List<Branches> getAll() {
        return (List<Branches>)repository.findAll();
    }

    @Override
    public Branches insert(Branches branches) {
        return repository.save(branches);
    }

    @Override
    public Branches update(Branches branches) {
        return repository.save(branches);
    }

    @Override
    public Branches getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Branches> getBranchesByWorkplaces(int firstAmount, int lastAmount) {
        return repository.getBranchesByWorkplaces(firstAmount, lastAmount);
    }
}
