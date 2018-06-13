package voblaweb.photo.service.hurrysupplies;

import voblaweb.photo.model.HurrySupplies;

import java.sql.Date;
import java.util.List;

public interface IHurrySuppliesService {
    List<HurrySupplies> getAll();
    HurrySupplies insert(HurrySupplies hurrySupplies);
    HurrySupplies update(HurrySupplies hurrySupplies);
    HurrySupplies getById(int id);
    void delete(int id);
    List<HurrySupplies> getHurrySuppliesByBranchId(int id);
    List<HurrySupplies> getHurrySuppliesByDone(String done);
    List<HurrySupplies> getHurrySuppliesByClientId(int id);
    List<HurrySupplies> getHurrySuppliesByDate(Date firstDate, Date secondDate);
    List<HurrySupplies> getHurrySuppliesByType(int id);
    List<HurrySupplies> getHurrySuppliesByTotalAmount(int firstNumber, int secondNumber);
}
