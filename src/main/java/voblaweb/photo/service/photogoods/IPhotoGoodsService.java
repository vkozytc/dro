package voblaweb.photo.service.photogoods;

import voblaweb.photo.model.PhotoGoods;

import java.util.List;

public interface IPhotoGoodsService {
    List<PhotoGoods> getAll();
    PhotoGoods insert(PhotoGoods photoGoods);
    PhotoGoods update(PhotoGoods photoGoods);
    PhotoGoods getById(int id);
    void delete(int id);
}
