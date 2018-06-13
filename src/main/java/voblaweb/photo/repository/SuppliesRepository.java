package voblaweb.photo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import voblaweb.photo.model.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface SuppliesRepository extends JpaRepository<Supplies,Integer> {

    @Query("select k from Supplies k where k.kioskId.id = :id")
    List<Supplies> getSuppliesByKioskId(@Param("id") int id);

    @Query("select k from Supplies k where k.done = :done")
    List<Supplies> getSuppliesByDone(@Param("done") String done);

    @Query("select k from Supplies k where k.clientId.id = :id")
    List<Supplies> getSuppliesByClientId(@Param("id") int id);

    @Query("select k from Supplies k where k.supplyDate between :firstDate and :secondDate")
    List<Supplies> getSuppliesByDate(@Param("firstDate") Date firstDate, @Param("secondDate") Date secondDate);

    @Query("select k from Supplies k where k.typeOfSupplyId.id = :id")
    List<Supplies> getSuppliesByType(@Param("id") int id);

    @Query("select k from Supplies k where k.totalAmountOfPhotos between :firstNumber and :secondNumber")
    List<Supplies> getSuppliesByTotalAmount(@Param("firstNumber") int firstNumber, @Param("secondNumber") int secondNumber);
}
