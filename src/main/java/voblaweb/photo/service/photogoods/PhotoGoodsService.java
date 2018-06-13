package voblaweb.photo.service.photogoods;

import voblaweb.photo.model.PhotoGoods;
import voblaweb.photo.repository.PhotoGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoGoodsService implements IPhotoGoodsService {

    @Autowired
    PhotoGoodsRepository repository;

    @Override
    public List<PhotoGoods> getAll() {
        return (List<PhotoGoods>)repository.findAll();
    }

    @Override
    public PhotoGoods insert(PhotoGoods photoGoods) {
        return repository.save(photoGoods);
    }

    @Override
    public PhotoGoods update(PhotoGoods photoGoods) {
        return repository.save(photoGoods);
    }

    @Override
    public PhotoGoods getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
