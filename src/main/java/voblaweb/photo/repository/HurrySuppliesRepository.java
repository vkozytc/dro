package voblaweb.photo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import voblaweb.photo.model.HurrySupplies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface HurrySuppliesRepository extends JpaRepository<HurrySupplies,Integer> {

    @Query("select k from HurrySupplies k where k.branchId.id = :id")
    List<HurrySupplies> getHurrySuppliesByBranchId(@Param("id") int id);

    @Query("select k from HurrySupplies k where k.done = :done")
    List<HurrySupplies> getHurrySuppliesByDone(@Param("done") String done);

    @Query("select k from HurrySupplies k where k.clientId.id = :id")
    List<HurrySupplies> getHurrySuppliesByClientId(@Param("id") int id);

    @Query("select k from Supplies k where k.supplyDate between :firstDate and :secondDate")
    List<HurrySupplies> getHurrySuppliesByDate(@Param("firstDate") Date firstDate, @Param("secondDate") Date secondDate);

    @Query("select k from HurrySupplies k where k.typeOfSupplyId.id = :id")
    List<HurrySupplies> getHurrySuppliesByType(@Param("id") int id);

    @Query("select k from HurrySupplies k where k.totalAmountOfPhotos between :firstNumber and :secondNumber")
    List<HurrySupplies> getHurrySuppliesByTotalAmount(@Param("firstNumber") int firstNumber, @Param("secondNumber") int secondNumber);
}