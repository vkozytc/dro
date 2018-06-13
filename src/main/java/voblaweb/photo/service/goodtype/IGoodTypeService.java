package voblaweb.photo.service.goodtype;

import voblaweb.photo.model.GoodType;

import java.util.List;

public interface IGoodTypeService {
    List<GoodType> getAll();
    GoodType insert(GoodType goodType);
    GoodType update(GoodType goodType);
    GoodType getById(int id);
    void delete(int id);
}
