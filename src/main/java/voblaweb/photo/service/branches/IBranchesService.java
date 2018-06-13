package voblaweb.photo.service.branches;

import voblaweb.photo.model.Branches;

import java.util.List;

public interface IBranchesService {
    List<Branches> getAll();
    Branches insert(Branches branches);
    Branches update(Branches branches);
    Branches getById(int id);
    void delete(int id);
    List<Branches> getBranchesByWorkplaces(int firstAmount, int lastAmount);
}
