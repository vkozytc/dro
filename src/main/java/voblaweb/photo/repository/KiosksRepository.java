package voblaweb.photo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import voblaweb.photo.model.Kiosks;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface KiosksRepository extends JpaRepository<Kiosks,Integer> {

    @Query("select k from Kiosks k where k.branchId.id = :id")
    List<Kiosks> getKiosksByBranchId(@Param("id") int id);

    @Query("select k from Kiosks k where k.amountOfWorkplaces between :firstAmount and :lastAmount")
    List<Kiosks> getKiosksByWorkplaces(@Param("firstAmount") int firstAmount, @Param("lastAmount") int lastAmount);


}
