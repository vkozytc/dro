package voblaweb.photo.service.goodtype;

import voblaweb.photo.model.GoodType;
import voblaweb.photo.repository.GoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodTypeService implements IGoodTypeService {

    @Autowired
    GoodTypeRepository repository;

    @Override
    public List<GoodType> getAll() {
        return (List<GoodType>)repository.findAll();
    }

    @Override
    public GoodType insert(GoodType goodType) {
        return repository.save(goodType);
    }

    @Override
    public GoodType update(GoodType goodType) {
        return repository.save(goodType);
    }

    @Override
    public GoodType getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
