package voblaweb.photo.service.kiosks;

import voblaweb.photo.model.Kiosks;

import java.util.List;

public interface IKiosksService {
    List<Kiosks> getAll();
    Kiosks insert(Kiosks kiosks);
    Kiosks update(Kiosks kiosks);
    Kiosks getById(int id);
    void delete(int id);
    List<Kiosks> getKiosksByBranchId(int id);
    List<Kiosks> getKiosksByWorkplaces(int firstAmount, int lastAmount);
}
