package voblaweb.photo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import voblaweb.photo.model.Branches;

import java.util.List;

@Repository
public interface BranchesRepository extends JpaRepository<Branches,Integer> {
    @Query("select k from Branches k where k.amountOfWorkplaces between :firstAmount and :lastAmount")
    List<Branches> getBranchesByWorkplaces(@Param("firstAmount") int firstAmount, @Param("lastAmount") int lastAmount);
}
