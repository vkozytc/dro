package voblaweb.photo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import voblaweb.photo.model.OfficeOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface OfficeOrdersRepository extends JpaRepository<OfficeOrders,Integer> {

    @Query("select k from OfficeOrders k where (k.photoGoodId.id = :id) and (k.dateOfSupply between :firstDate and :secondDate)")
    List<OfficeOrders> getOfficeOrdersByPhotoGoodIdAndDate(@Param("id") int id, @Param("firstDate") Date firstDate, @Param("secondDate") Date secondDate);

//    @Query("select k from Supplies k where k.supplyDate between :firstDate and :secondDate")
//    List<OfficeOrders> getOfficeOrdersByDate(@Param("firstDate") Date firstDate, @Param("secondDate") Date secondDate);
}
