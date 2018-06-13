package voblaweb.photo.service.supplies;

import voblaweb.photo.model.Supplies;

import java.sql.Date;
import java.util.List;

public interface ISuppliesService {
    List<Supplies> getAll();
    Supplies insert(Supplies supplies);
    Supplies update(Supplies supplies);
    Supplies getById(int id);
    void delete(int id);
    List<Supplies> getSuppliesByKioskId(int id);
    List<Supplies> getSuppliesByDone(String done);
    List<Supplies> getSuppliesByClientId(int id);
    List<Supplies> getSuppliesByDate(Date firstDate, Date secondDate);
    List<Supplies> getSuppliesByType(int id);
    List<Supplies> getSuppliesByTotalAmount(int firstNumber, int secondNumber);
}
