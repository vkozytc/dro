package voblaweb.photo.repository;

import org.springframework.data.repository.CrudRepository;
import voblaweb.photo.model.ServiceSupplies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceSuppliesRepository extends JpaRepository<ServiceSupplies,Integer> {
}
