package voblaweb.photo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import voblaweb.photo.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients,Integer> {

    @Query("select k from Clients k where k.branchId.id = :id")
    List<Clients> getClientsByBranchId(@Param("id") int id);

    @Query("select k from Clients k where k.type = :kType")
    List<Clients> getClientsByType(@Param("kType") String kType);

    @Query("select k from Clients k where k.discount between :kFirst and :kLast")
    List<Clients> getClientsByDiscount(@Param("kFirst") int kFirst, @Param("kLast") int kLast);
}
